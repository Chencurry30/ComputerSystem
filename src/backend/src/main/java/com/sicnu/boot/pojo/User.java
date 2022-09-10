package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private long userId;
  private String username;
  private String password;
  private String phone;
  private String email;
  private long age;
  private long sex;
  private long role;
  private String image;
  private long powerId;
}
