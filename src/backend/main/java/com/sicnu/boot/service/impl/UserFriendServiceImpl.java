package com.sicnu.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.mapper.UserFriendMapper;
import com.sicnu.boot.pojo.FriendExamine;
import com.sicnu.boot.service.UserFriendService;
import com.sicnu.boot.utils.RedisUtils;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.LoginUser;
import com.sicnu.boot.vo.UserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/03 16:22
 */
@Service
public class UserFriendServiceImpl implements UserFriendService {

    @Resource
    private UserFriendMapper userFriendMapper;

    @Resource
    private RedisUtils redisUtils;

    @Override
    public ServerResponse<List<UserDetail>> getFriends() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((LoginUser) authentication.getPrincipal()).getUser().getUserId();
        List<UserDetail> friends = userFriendMapper.getFriendsByUserId(userId);
        List<Integer> cacheList = redisUtils.getCacheList("redSpot:" + userId);
        for (UserDetail friend : friends) {
            if (cacheList.contains(friend.getUserId())){
                friend.setIsRedSpot(1);
            }else {
                friend.setIsRedSpot(0);
            }
        }
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
        return ServerResponse.createBySuccess("获取成功",list);
    }

    @Override
    public ServerResponse<String> addFriend(FriendExamine friendExamine) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        friendExamine.setUserId(((LoginUser)authentication.getPrincipal()).getUser().getUserId());
        int checkAddFriend = userFriendMapper.checkAddFriend(friendExamine.getUserId(), friendExamine.getFriendId());
        if (checkAddFriend > 0){
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
    public ServerResponse<String> examineFriend(FriendExamine friendExamine) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        friendExamine.setUserId(((LoginUser)authentication.getPrincipal()).getUser().getUserId());
        int returnCount = userFriendMapper.examineFriend(friendExamine);
        if (friendExamine.getStatus() == 1 && returnCount > 0){
            //通过好友申请
            userFriendMapper.insertFriend(friendExamine.getUserId(),friendExamine.getFriendId());
            userFriendMapper.insertFriend(friendExamine.getFriendId(),friendExamine.getUserId());
            return ServerResponse.createBySuccessMessage("同意申请成功");
        }else if (returnCount == 0){
            return ServerResponse.createByErrorMessage("无效的操作");
        }
        return ServerResponse.createBySuccessMessage("拒绝申请成功");
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
        PageInfo<FriendExamine> pageInfo = new PageInfo<>(list);
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }

    @Override
    public ServerResponse<Boolean> getRedSpot() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Integer userId = ((LoginUser) authentication.getPrincipal()).getUser().getUserId();
        List<Integer> cacheList = redisUtils.getCacheList("redSpot" + userId);
        return ServerResponse.createBySuccess("获取成功",cacheList.isEmpty());
    }
}
