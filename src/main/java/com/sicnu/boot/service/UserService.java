package com.sicnu.boot.service;

import com.sicnu.boot.common.ServerResponse;

/**
 * @projectName: computer-system
 * @package: com.sicnu.boot.service
 * @className: UserService
 * @description: TODO
 * @date: 2022-09-09 20:26
 * @version:
 */

public interface UserService {
    /**
     * @param username: 用户名
     * @param password: 密码
     * @return User
     * @description 通过用户名和密码登录
     * @date 2022/9/9 20:47
     */
    ServerResponse login(String username, String password);

    /**
     * @param username:
     * @param password:
     * @return ServerResponse
     * @author hjh
     * @description 通过用户名和密码进行注册
     * @date 2022/9/11 9:35
     */
    ServerResponse register(String username,String password);

}
