package com.sicnu.boot.controller;

import com.sicnu.boot.service.UserFriendService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.UserDetail;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/03 16:21
 */
@RestController
@RequestMapping("/friends")
@Validated
public class UserFriendController {
    @Resource
    private UserFriendService userFriendService;

    /**
     * description: 获取用户的好友列表
     *
     * @param userId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/3 16:31
     */
    @GetMapping("/{userId}")
    public ServerResponse<List<UserDetail>> getFriends(@PathVariable Integer userId){
        return userFriendService.getFriends(userId);
    }
}
