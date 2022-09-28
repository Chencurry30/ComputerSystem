package com.sicnu.boot.pojo;

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
  private Long userId;
  private String username;
  private String nickname;
  private String password;
  private String phone;
  private String email;
  private Long age;
  private Long sex;
  private Long role;
  private String image;
  private Long powerId;

  /**
   * description: 手机验证码
   */
  private String smsCode;
}
