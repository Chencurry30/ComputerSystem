package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:  修改用户信息的映射类
 *
 * @author :  胡建华
 * Data:    2022/10/03 20:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUser {
    private String oldPhone;
    private String phone;
    private String oldPassword;
    private String password;
    private String oldSmsCode;
    private String smsCode;
}
