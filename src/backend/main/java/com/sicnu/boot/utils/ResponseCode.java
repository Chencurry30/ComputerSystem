package com.sicnu.boot.utils;

/**
 * description:  响应码
 * @author :     胡建华
 * Data: 2022-09-10 10:36
 */
public enum ResponseCode {
    //TODO 添加响应码
    
    /**
     * description: 成功响应码
     */
    SUCCESS(200,"SUCCESS"),
    /**
     * description: 错误响应码
     */
    ERROR(400,"ERROR"),
    /**
     * description: 响应码
     */
    NEED_LOGIN(402,"NEED_LOGIN"),
    /**
     * description: 参数非法响应码
     */
    ILLEGAL_ARGUMENT(406,"ILLEGAL_ARGUMENT");

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
