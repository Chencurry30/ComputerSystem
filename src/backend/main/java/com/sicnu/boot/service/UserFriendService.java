package com.sicnu.boot.service;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.FriendExamine;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.UserDetail;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/03 16:22
 */
public interface UserFriendService {
    /**
     * description: 获取用户的好友列表
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/3 16:31
     */
    ServerResponse<List<UserDetail>> getFriends();

    /**
     * description: 通过昵称搜索好友
     *
     * @param nickname:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/6 15:08
     */
    ServerResponse<List<UserDetail>> getUserListByNickname(String nickname);

    /**
     * description: 添加好友
     *
     * @param friendExamine:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/6 15:18
     */
    ServerResponse<String> addFriend(FriendExamine friendExamine);

    /**
     * description: 审核好友
     *
     * @param friendExamine:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/6 16:22
     */
    ServerResponse<String> examineFriend(FriendExamine friendExamine);

    /**
     * description: 获取审核列表
     *
     * @param status:
     * @param type:
     * @param pageNum:
     * @return ServerResponse<List<FriendExamine>>
     * @author 胡建华
     * Date:  2022/12/6 20:43
     */
    ServerResponse<PageInfo<FriendExamine>> getExamineList(Integer status, Integer type, Integer pageNum);

    /**
     * description: 获取小红点
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/8 10:52
     */
    ServerResponse<Boolean> getRedSpot();

    /**
     * description: 取消申请
     *
     * @param friendId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/8 15:07
     */
    ServerResponse<String> cancelExamine(Integer friendId);

    /**
     * description: 删除指定好友
     *
     * @param friendId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2023/1/2 21:00
     */
    ServerResponse<String> deleteFriend(Integer friendId);
}
