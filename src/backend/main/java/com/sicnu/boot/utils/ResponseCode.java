package com.sicnu.boot.utils;

/**
 * description:  响应码
 * @author :     胡建华
 * Data: 2022-09-10 10:36
 */
public enum ResponseCode {
    /**
     * description: 成功响应码
     */
    SUCCESS(200,"SUCCESS"),
    /**
     * description: 一般错误响应码
     */
    ERROR(400,"ERROR"),
    /**
     * description: 没有认证或认证失败，需要登录
     */
    UNAUTHORIZED(401,"UNAUTHORIZED"),
    /**
     * description: 没有权限，禁止访问
     */
    FORBIDDEN(403,"FORBIDDEN"),
    /**
     * description: 参数非法
     */
    ILLEGAL_ARGUMENT(406,"ILLEGAL_ARGUMENT"),
    /**
     * description: 手机验证码错误
     */
    SMS_CODE_ERROR(407,"SMS_CODE_ERROR"),
    /**
     * description: 手机验证码失效
     */
    SMS_CODE_INVALID(408,"SMS_CODE_INVALID"),
    /**
     * description: 用户名或密码错误
     */
    USERNAME_OR_PASSWORD_ERROR(409,"USERNAME_OR_PASSWORD_ERROR"),
    /**
     * description: 注册时，用户名重复
     */
    USERNAME_REPEAT(411,"USERNAME_REPEAT"),
    /**
     * description: 手机号重复
     */
    PHONE_REPEAT(413,"PHONE_REPEAT"),
    /**
     * description: 验证码发送失败
     */
    SMS_NOT_SEND(414,"SMS_NOT_SEND"),
    /**
     * description: 不存在此用户
     */
    USER_NOT_FOUND(415,"NOT_HAVE_USER"),
    /**
     * description: 没有数据
     */
    HAS_NO_DATA(417,"HAS_NO_DATA"),
    /**
     * description: 服务器异常
     */
    INTERNAL_SERVER_ERROR(500,"INTERNAL_SERVER_ERROR");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
