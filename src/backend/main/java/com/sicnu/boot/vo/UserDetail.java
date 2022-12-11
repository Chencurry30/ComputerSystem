package com.sicnu.boot.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sicnu.boot.group.Insert;
import com.sicnu.boot.group.Phone;
import com.sicnu.boot.group.Update;
import com.sicnu.boot.pojo.Role;
import com.sicnu.boot.pojo.User;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.*;
import java.util.List;

/**
 * description:  返回用户信息的封装类
 *
 * @author :  胡建华
 * Data:    2022/09/30 9:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetail {
    @NotNull(message = "userId不能为空",groups = {Update.class})
    private Integer userId;
    @NotBlank(message = "用户名不能为空",groups = {Insert.class})
    @NotNull(message = "用户名不能为空",groups = {Insert.class})
    @Pattern(regexp = "^[a-zA-Z0-9]{2,12}$", message = "用户名长度必须为2-12,且只能包含数字和字母")
    private String username;
    @Length(min = 2,max = 12,message = "昵称长度必须为2-12")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z0-9]{2,12}$",
            message = "昵称长度必须为2-12,且只能包含数字，字母和中文")
    private String nickname;
    @Range(min = 1,max = 150,message = "年龄大小必须为1-150")
    @NotNull(message = "年龄不能为空",groups = {Insert.class,Update.class})
    private Integer age;
    @NotBlank(message = "手机号码不能为空", groups = {Phone.class})
    @NotNull(message = "手机号不能为空", groups = {Phone.class})
    @Length(min = 11, max = 11, message = "手机号只能为11位")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式有误")
    private String phone;
    private String password;
    @Email(message = "邮箱格式不规范")
    @NotNull(message = "邮箱不能为空",groups = {Insert.class,Update.class})
    @NotBlank(message = "邮箱不能为空",groups = {Insert.class,Update.class})
    private String email;
    private String image;
    @Length(min = 1,max = 2,message = "性别长度必须为1-2")
    @NotNull(message = "性别不能为空",groups = {Insert.class,Update.class})
    private String sex;
    @NotBlank(message = "验证码不能为空",groups = {Phone.class})
    @Length(min = 4,max = 4,message = "验证码的长度只能为4")
    private String smsCode;
    private String message;
    private Integer isFriend;
    private Integer isRedSpot;
    private List<Role> roles;
    private Role roleOne;
    public UserDetail(String nickname,String image,Integer userId){
        this.nickname = nickname;
        this.image = image;
        this.userId = userId;
    }

    public UserDetail(User user){
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.age = user.getAge();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.image = user.getImage();
        this.sex = user.getSex();
        this.message = user.getMessage();
    }

    public UserDetail(String nickname, String image, Integer userId, String phone) {
        this.nickname = nickname;
        this.image = image;
        this.userId = userId;
        this.phone = phone;
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
                ", message='" + message + '\'' +
                '}';
    }
}
