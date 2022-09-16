package com.sicnu.boot.service;

import com.sicnu.boot.common.ServerResponse;

import java.util.Map;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-09 20:26
 */

public interface UserService {

    /**
     * description: 通过用户名和密码登录
     *
     * @param username: 用户名
     * @param password: 密码
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/9/15 19:17
     */
    ServerResponse<Map<String,String>> login(String username, String password);

    /**
     * description: 通过用户名和密码进行注册
     *
     * @param username: 用户名
     * @param password: 密码
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/9/15 19:18
     */
    ServerResponse<String> register(String username,String password);

}