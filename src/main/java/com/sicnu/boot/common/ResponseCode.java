package com.sicnu.boot.common;

/**
 * @projectName: computer-system
 * @package: com.sicnu.boot.common
 * @className: ResponseCode
 * @author: hjh
 * @description: TODO
 * @date: 2022-09-10 10:36
 * @version:
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
