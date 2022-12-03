package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.UserFriendMapper;
import com.sicnu.boot.service.UserFriendService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.UserDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public ServerResponse<List<UserDetail>> getFriends(Integer userId) {
        List<UserDetail> friends = userFriendMapper.getFriendsByUserId(userId);
        return ServerResponse.createBySuccess("获取成功",friends);
    }
}
