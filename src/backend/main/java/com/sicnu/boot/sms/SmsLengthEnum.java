package com.sicnu.boot.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * description: 验证码长度类
 * @author :  胡建华
 * Data: 2022-09-15 11:12
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SmsLengthEnum {

    /** 4位短信验证码 */
    SMS_LENGTH_4(4),
    /** 6位短信验证码 */
    SMS_LENGTH_6(6);

    private int length;
}
