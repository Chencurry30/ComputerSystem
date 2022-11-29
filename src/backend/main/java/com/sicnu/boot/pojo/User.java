package com.sicnu.boot.pojo;

import com.sicnu.boot.group.Phone;
import com.sicnu.boot.vo.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-09 20:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private Integer userId;
  @NotBlank(message = "用户名不能为空")
  @Pattern(regexp = "^[a-zA-Z0-9]{2,12}$", message = "用户名长度必须为2-12,且只能包含数字和字母")
  private String username;
  private String nickname;
  @NotBlank(message = "密码不能为空")
  private String password;
  @NotBlank(message = "手机号码不能为空", groups = {Phone.class})
  @NotNull(message = "手机号不能为空", groups = {Phone.class})
  @Length(min = 11, max = 11, message = "手机号只能为11位")
  @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式有误")
  private String phone;
  private String email;
  private Integer age;
  private String sex;
  private String image;
  /**
   * description: 个人留言
   */
  private String message;

  /**
   * description: 手机验证码
   */
  @NotBlank(message = "验证码不能为空",groups = {Phone.class})
  @Length(min = 4,max = 4,message = "验证码的长度只能为4")
  private String smsCode;

  /**
   * description: 用户公钥唯一认证码
   */
  @Length(min = 10,message = "uuid长度最小为10")
  @NotBlank(message = "uuid不能为空")
  @NotNull(message = "uuid不能为空")
  private String uuId;

  public User(Integer userId, UserDetail userDetail){
    this.userId = userId;
    this.nickname = userDetail.getNickname();
    this.age = userDetail.getAge();
    this.email = userDetail.getEmail();
    this.image = userDetail.getImage();
    this.sex = userDetail.getSex();
    this.message = userDetail.getMessage();
  }
}
