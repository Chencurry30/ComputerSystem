package com.sicnu.boot.service;

import com.sicnu.boot.utils.ServerResponse;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-15 11:41
 */
public interface ISmsService {

    /**
     * description: 发送短信验证码
     *
     * @param phone 手机号
     * @return : 返回响应码
     * @author 胡建华
     * Date: 2020/9/16 10:11
     */
    ServerResponse<String> sendSmsCode(String phone);

    /**
     * description:验证短信验证码
     *
     * @param phone 手机号
     * @param code  验证码
     * @return : 返回响应码
     * @author 胡建华
     * Date: 2020/9/16 10:11
     */
    ServerResponse<String> verifyCode(String phone, String code);

}
