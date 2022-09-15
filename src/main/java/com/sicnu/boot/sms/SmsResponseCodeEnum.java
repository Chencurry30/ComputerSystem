package com.sicnu.boot.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * description:  腾讯云响应内容
 * @author :     胡建华
 * Data: 2022-09-15 14:57
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SmsResponseCodeEnum {

    /**
     * 发送成功
     * 数据结构 "SendStatusSet":[{"Code":"Ok"}]
     */
    OK("Ok", "send success"),

    /*
      失败数据结构
        {
            "Response": {
                "Error": {
                    "Code": "AuthFailure.SignatureFailure",
                    "Message": "The provided credentials could not be validated. Please check your signature is
                    correct."
                },
                "RequestId": "ed93f3cb-f35e-473f-b9f3-0d451b8b79c6"
            }
        }
        详情参考：https://cloud.tencent.com/document/product/382/38780
     */

    ;
    /** 状态码 */
    private String code;

    /** 描述信息 */
    private String message;

}
