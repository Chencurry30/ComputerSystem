package com.sicnu.boot.vo;

import com.sicnu.boot.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:  返回用户信息的封装类
 *
 * @author :  胡建华
 * Data:    2022/09/30 9:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    private String username;
    private String nickname;
    private Integer age;
    private String phone;
    private String email;
    private String image;
    private Integer sex;
    private String smsCode;
    public UserDetail(String nickname,String image){
        this.nickname = nickname;
        this.image = image;
    }

    public UserDetail(User user){
        this.nickname = user.getNickname();
        this.image = user.getImage();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.username = user.getUsername();
        this.sex = user.getSex();
    }
}
