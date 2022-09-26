package com.sicnu.boot.utils;

/**
 * description:  响应码
 * @author :     胡建华
 * Data: 2022-09-10 10:36
 */
public enum ResponseCode {
    SUCCESS(200,"SUCCESS"),
    ERROR(201,"ERROR"),
    NEED_LOGIN(202,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(203,"ILLEGAL_ARGUMENT");

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
