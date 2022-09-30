package com.sicnu.boot.pojo;

import com.sicnu.boot.vo.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  private String username;
  private String nickname;
  private String password;
  private String phone;
  private String email;
  private Integer age;
  private Integer sex;
  private Integer role;
  private String image;
  private Integer powerId;

  /**
   * description: 手机验证码
   */
  private String smsCode;

  public User(Integer userId, UserDetail userDetail){
    this.userId = userId;
    this.nickname = userDetail.getNickname();
    this.age = userDetail.getAge();
    this.email = userDetail.getEmail();
    this.image = userDetail.getImage();
    this.sex = userDetail.getSex();
  }
}
