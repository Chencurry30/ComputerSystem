package com.sicnu.boot.service;

import com.sicnu.boot.pojo.User;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.UpdateUser;
import com.sicnu.boot.vo.UserDetail;

import java.util.Map;

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
    ServerResponse<Map<String,Object>> login(User user);

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
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/9/26 22:51
     */
    ServerResponse<String> logout();

    /**
     * description: 返回用户个人信息
     *
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/9/30 9:39
     */
    ServerResponse<UserDetail> getUserDetail();

    /**
     * description: 修改用户信息
     *
     * @param userDetail:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/9/30 16:19
     */
    ServerResponse<UserDetail> updateUserDetail(UserDetail userDetail);

    /**
     * description: 忘记密码
     *
     * @param user:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/3 16:17
     */
    ServerResponse<String> forgetPassword(User user);

    /**
     * description: 忘记用户名
     *
     * @param userDetail:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/3 16:17
     */
    ServerResponse<Map<String,String>> forgetUsername(UserDetail userDetail);

    /**
     * description: 修改手机号
     *
     * @param updateUser:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/3 21:11
     */
    ServerResponse<String> updatePhone(UpdateUser updateUser);

    /**
     * description: 修改密码
     *
     * @param updateUser:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/3 21:11
     */
    ServerResponse<String> updatePassword(UpdateUser updateUser);

    /**
     * description: 通过用户id获取用户信息
     *
     * @param userId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/11 15:25
     */
    ServerResponse<Map<String,String>> getUserByUserId(Integer userId);

    /**
     * description: 获取RSA加密的公钥
     *
     * @param uuId :
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/10/18 21:45
     */
    ServerResponse<String> getPublicKey(String uuId);

    /**
     * description: 绑定手机号
     *
     * @param updateUser:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/11 15:09
     */
    ServerResponse<String> bindPhone(UpdateUser updateUser);
}
