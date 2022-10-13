package com.sicnu.boot.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sicnu.boot.pojo.User;
import lombok.*;

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
    private String sex;
    private String smsCode;
    private Integer isHide;
    private String massage;
    public UserDetail(String nickname,String image){
        this.nickname = nickname;
        this.image = image;
    }

    public UserDetail(User user){
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.age = user.getAge();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.image = user.getImage();
        this.sex = user.getSex();
        this.isHide = user.getIsHide();
        this.massage = user.getMessage();
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", sex='" + sex + '\'' +
                ", isHide=" + isHide +
                ", massage='" + massage + '\'' +
                '}';
    }
}
