package com.sicnu.boot.service;

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
     * @param userId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/3 16:31
     */
    ServerResponse<List<UserDetail>> getFriends(Integer userId);
}
