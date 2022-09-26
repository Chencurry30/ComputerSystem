package com.sicnu.boot.service;

import com.sicnu.boot.pojo.User;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.web.bind.annotation.RequestBody;

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

}
