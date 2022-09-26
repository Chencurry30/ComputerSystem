package com.sicnu.boot.service;

import com.sicnu.boot.pojo.User;
import com.sicnu.boot.utils.ServerResponse;

/**
 * description:
 *
 * @author :     胡建华
 * Data: 2022-09-09 20:26
 */

public interface UserService {

    /**
     * description: 通过用户名和密码登录
     *
     * @param user: 用户
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/9/15 19:17
     */
    ServerResponse login(User user);

    /**
     * description: 通过用户名和密码进行注册
     *
     * @param user: 用户
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/9/15 19:18
     */
    ServerResponse<String> register(User user);

    /**
     * description: 退出登录，删除redis存储信息
     *
     * @param :
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/9/26 22:51
     */
    ServerResponse logout();
}
