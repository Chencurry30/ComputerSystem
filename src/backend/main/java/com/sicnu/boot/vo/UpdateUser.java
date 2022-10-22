package com.sicnu.boot.vo;

import com.sicnu.boot.group.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    @NotBlank(message = "手机号码不能为空", groups = {Phone.class})
    @NotNull(message = "手机号不能为空", groups = {Phone.class})
    @Length(min = 11, max = 11, message = "手机号只能为11位")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式有误")
    private String oldPhone;
    @NotBlank(message = "手机号码不能为空")
    @NotNull(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号只能为11位")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式有误")
    private String phone;
    private String oldPassword;
    private String password;
    @NotBlank(message = "验证码不能为空",groups = {Phone.class})
    @Length(min = 4,max = 4,message = "验证码的长度只能为4")
    private String oldSmsCode;
    @NotBlank(message = "验证码不能为空")
    @Length(min = 4,max = 4,message = "验证码的长度只能为4")
    private String smsCode;
    private String uuId;
}
