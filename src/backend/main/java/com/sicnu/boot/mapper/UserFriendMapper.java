package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.FriendExamine;
import com.sicnu.boot.vo.UserDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/03 16:23
 */
@Mapper
public interface UserFriendMapper {
    /**
     * description: 通过用户id获取用户列表
     *
     * @param userId:
     * @return List<UserDetail>
     * @author 胡建华
     * Date:  2022/12/3 16:27
     */
    List<UserDetail> getFriendsByUserId(Integer userId);

    /**
     * description: 通过昵称查询好友
     *
     * @param nickname:
     * @return List<UserDetail>
     * @author 胡建华
     * Date:  2022/12/6 15:10
     */
    List<UserDetail> getUserListByNickname(String nickname);

    /**
     * description: 添加好友
     *
     * @param friendExamine:
     * @author 胡建华
     * Date:  2022/12/6 15:36
     */
    void addFriend(FriendExamine friendExamine);

    /**
     * description: 检查用户对好友的状态
     *
     * @param userId:
     * @param friendId:
     * @return int
     * @author 胡建华
     * Date:  2022/12/6 15:47
     */
    int checkAddFriend(Integer userId,Integer friendId);

    /**
     * description: 审核好友
     *
     * @param friendExamine:
     * @return int
     * @author 胡建华
     * Date:  2022/12/6 16:37
     */
    int examineFriend(FriendExamine friendExamine);

    /**
     * description: 添加好友
     *
     * @param userId:
     * @param friendId:
     * @author 胡建华
     * Date:  2022/12/6 16:42
     */
    void insertFriend(Integer userId,Integer friendId);

    /**
     * description: 检查两人是否是好友
     *
     * @param userId:
     * @param friendId:
     * @return void
     * @author 胡建华
     * Date:  2022/12/6 16:46
     */
    int checkFriend(Integer userId,Integer friendId);

    /**
     * description: 获取该用户的申请列表
     *
     * @param status:
     * @param userId:
     * @return List<FriendExamine>
     * @author 胡建华
     * Date:  2022/12/6 20:01
     */
    List<FriendExamine> getUserExamineList(Integer status,Integer userId);

    /**
     * description: 获取该用户的好友申请列表
     *
     * @param status:
     * @param userId:
     * @return List<FriendExamine>
     * @author 胡建华
     * Date:  2022/12/6 20:48
     */
    List<FriendExamine> getFriendExamineList(Integer status,Integer userId);

    /**
     * description: 获取好友信息
     *
     * @param userId:
     * @return UserDetail
     * @author 胡建华
     * Date:  2022/12/7 21:02
     */
    UserDetail getFriendByKey(Integer userId);

    /**
     * description: 取消申请
     *
     * @param userId:
     * @param friendId:
     * @author 胡建华
     * Date:  2022/12/8 15:09
     */
    void cancelExamine(Integer userId, Integer friendId);

    /**
     * description: 删除指定好友
     *
     * @param userId:
     * @param friendId:
     * @author 胡建华
     * Date:  2023/1/2 21:02
     */
    void deleteFriend(Integer userId, Integer friendId);
}
