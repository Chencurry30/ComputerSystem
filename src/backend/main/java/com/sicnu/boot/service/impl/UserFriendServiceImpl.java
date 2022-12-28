package com.sicnu.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.aop.SysLogAnnotation;
import com.sicnu.boot.mapper.UserFriendMapper;
import com.sicnu.boot.pojo.FriendExamine;
import com.sicnu.boot.service.UserFriendService;
import com.sicnu.boot.utils.RedisUtils;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.LoginUser;
import com.sicnu.boot.vo.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/03 16:22
 */
@Service
@Slf4j
public class UserFriendServiceImpl implements UserFriendService {

    @Resource
    private UserFriendMapper userFriendMapper;

    @Resource
    private RedisUtils redisUtils;
    /**
     * description: redis获取好友列表前缀
     */
    private final String REDIS_FRIEND_PREFIX = "friendList:";

    @Override
    public ServerResponse<List<UserDetail>> getFriends() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((LoginUser) authentication.getPrincipal()).getUser().getUserId();
        //从redis中获取好友列表
        List<UserDetail> friends = redisUtils.getCacheList(REDIS_FRIEND_PREFIX + userId);
        if (Objects.isNull(friends) || friends.isEmpty()){
            //如果没有获取到，说明redis中没有，需要从数据库中获取
            friends = userFriendMapper.getFriendsByUserId(userId);
            if (!friends.isEmpty()){
                redisUtils.setCacheList(REDIS_FRIEND_PREFIX + userId,friends);
            }
            //设置有效时间
            redisUtils.expire(REDIS_FRIEND_PREFIX + userId,24, TimeUnit.HOURS);
        }
        if (friends.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        List<Integer> cacheList = redisUtils.getCacheList("redSpot:" + userId);
        for (UserDetail friend : friends) {
            if (cacheList.contains(friend.getUserId())){
                friend.setIsRedSpot(1);
            }else {
                friend.setIsRedSpot(0);
            }
        }
        //排序
        friends.sort(Comparator.comparingInt(UserDetail::getIsRedSpot));
        return ServerResponse.createBySuccess("获取成功",friends);
    }

    @Override
    public ServerResponse<List<UserDetail>> getUserListByNickname(String nickname) {
        List<UserDetail> list = userFriendMapper.getUserListByNickname(nickname);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((LoginUser) authentication.getPrincipal()).getUser().getUserId();
        for (UserDetail userDetail : list) {
            //设置好友状态
            if (userId.equals(userDetail.getUserId())){
                userDetail.setIsFriend(1);
            }else {
                userDetail.setIsFriend(userFriendMapper.checkFriend(userId,
                        userDetail.getUserId()));
            }
        }
        if (list.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("获取成功",list);
    }

    @Override
    @SysLogAnnotation(operModel = "社交管理",operType = "添加",operDesc = "用户添加好友")
    public ServerResponse<String> addFriend(FriendExamine friendExamine) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        friendExamine.setUserId(((LoginUser)authentication.getPrincipal()).getUser().getUserId());
        int checkAddFriend = userFriendMapper.checkAddFriend(friendExamine.getUserId(), friendExamine.getFriendId());
        if (checkAddFriend > 0){
            log.error("无法添加好友，原因是：该用户已经申请添加了好友");
            return ServerResponse.createByErrorMessage("该用户已经申请添加了好友");
        }
        if (friendExamine.getFriendId().equals(friendExamine.getUserId())){
            return ServerResponse.createByErrorMessage("用户不能添加自己为好友");
        }
        int checkFriend = userFriendMapper.checkFriend(friendExamine.getUserId(), friendExamine.getUserId());
        if (checkFriend > 0){
            return ServerResponse.createByErrorMessage("该用户已经添加了该好友");
        }
        friendExamine.setTime(LocalDateTime.now());
        userFriendMapper.addFriend(friendExamine);
        return ServerResponse.createBySuccess("添加成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @SysLogAnnotation(operModel = "社交管理",operType = "审核",operDesc = "用户对好友申请进行管理")
    public ServerResponse<String> examineFriend(FriendExamine friendExamine) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        friendExamine.setUserId(((LoginUser)authentication.getPrincipal()).getUser().getUserId());
        int returnCount = userFriendMapper.examineFriend(friendExamine);
        if (friendExamine.getStatus() == 1 && returnCount > 0){
            //通过好友申请
            int checkFriend = userFriendMapper.checkFriend(friendExamine.getUserId(), friendExamine.getFriendId());
            if (checkFriend > 0){
                return ServerResponse.createByErrorMessage("该用户与你已经是好友了");
            }
            userFriendMapper.insertFriend(friendExamine.getUserId(),friendExamine.getFriendId());
            userFriendMapper.insertFriend(friendExamine.getFriendId(),friendExamine.getUserId());
            //添加好友成功之后，对redis进行更新
            updateRedisUserFriend(friendExamine.getUserId(),friendExamine.getFriendId());
            updateRedisUserFriend(friendExamine.getFriendId(), friendExamine.getUserId());
            log.info("同意申请成功");
            return ServerResponse.createBySuccessMessage("同意申请成功");
        }else if (returnCount == 0){
            return ServerResponse.createByErrorMessage("无效的操作");
        }
        return ServerResponse.createBySuccessMessage("拒绝申请成功");
    }

    /**
     * description: 更新好友列表的redis缓存
     *
     * @param userId:
     * @param friendId:
     * @author 胡建华
     * Date:  2022/12/15 10:20
     */
    private void updateRedisUserFriend(Integer userId, Integer friendId) {
        List<UserDetail> cacheList = redisUtils.getCacheList(REDIS_FRIEND_PREFIX + userId);
        if (Objects.isNull(cacheList) || cacheList.isEmpty()){
            //redis中没有数据，直接从数据库中获取更新
            cacheList = userFriendMapper.getFriendsByUserId(userId);
            if (!cacheList.isEmpty()){
                redisUtils.setCacheList(REDIS_FRIEND_PREFIX + userId,cacheList);
                //设置有效时间
                redisUtils.expire(REDIS_FRIEND_PREFIX + userId,24, TimeUnit.HOURS);
            }
        }else {
            //更新
            UserDetail friend = userFriendMapper.getFriendByKey(friendId);
            redisUtils.pushCacheList(REDIS_FRIEND_PREFIX + userId,friend);
        }
    }

    @Override
    public ServerResponse<PageInfo<FriendExamine>> getExamineList(Integer status, Integer type, Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((LoginUser) authentication.getPrincipal()).getUser().getUserId();
        List<FriendExamine> list;
        if (type == 0){
            list = userFriendMapper.getUserExamineList(status,userId);
        }else {
            list = userFriendMapper.getFriendExamineList(status,userId);
        }
        for (FriendExamine friendExamine : list) {
            UserDetail friendByKey = userFriendMapper.getFriendByKey(friendExamine.getFriendId());
            friendExamine.setFriend(friendByKey);
            UserDetail friendByKey1 = userFriendMapper.getFriendByKey(friendExamine.getUserId());
            friendExamine.setUser(friendByKey1);
        }
        if (list.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        PageInfo<FriendExamine> pageInfo = new PageInfo<>(list);
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }

    @Override
    public ServerResponse<Boolean> getRedSpot() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((LoginUser) authentication.getPrincipal()).getUser().getUserId();
        List<Integer> cacheList = redisUtils.getCacheList("redSpot:" + userId);
        return ServerResponse.createBySuccess("获取成功",!cacheList.isEmpty());
    }

    @Override
    public ServerResponse<String> cancelExamine(Integer friendId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((LoginUser) authentication.getPrincipal()).getUser().getUserId();
        userFriendMapper.cancelExamine(userId,friendId);
        return ServerResponse.createBySuccessMessage("取消申请成功");
    }
}
