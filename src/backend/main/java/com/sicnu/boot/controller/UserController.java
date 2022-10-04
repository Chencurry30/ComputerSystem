package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.User;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.service.ISmsService;
import com.sicnu.boot.service.UserService;
import com.sicnu.boot.vo.UpdateUser;
import com.sicnu.boot.vo.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * description:   用户控制类
 * @author :     胡建华
 * Data: 2022-09-09 20:31
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private ISmsService smsService;

    /**
     * description: 测试接口
     *
     * @return String
     * @author 胡建华
     * Date:  2022/9/28 22:08
     */
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    /**
     * description: 登录接口，需要用户名和密码
     *
     * @param user:
     * @return ServerResponse<Map<String,String>>
     * @author 胡建华
     * Date:  2022/9/28 22:08
     */
    @PostMapping("/login")
    public ServerResponse<Map<String,Object>> login(@RequestBody User user){
        return userService.login(user);
    }

    /**
     * description: 退出登录接口，需要请求头携带token
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/9/28 22:08
     */
    @PostMapping("/logout")
    public ServerResponse<String> logout(){
        return userService.logout();
    }

    /**
     * description: 注册接口，需要用户名，密码，手机号，和手机号验证码
     *
     * @param user:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/9/28 22:10
     */
    @PostMapping("/register")
    public ServerResponse<String> register(@RequestBody User user){
        return userService.register(user);
    }

    /**
     * description: 发送手机验证码
     *
     * @param map:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/9/28 22:11
     */
    @PostMapping("/sms")
    public ServerResponse<String> sendSms(@RequestBody Map<String,String> map){
        String phoneName = "phone";
        if (!map.containsKey(phoneName)){
            log.info("手机号为空");
            return ServerResponse.createByErrorMessage("手机号为空");
        }
        String phone = map.get("phone");
        return smsService.sendSmsCode(phone);
    }

    /**
     * description: 验证手机验证码
     *
     * @param map:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/9/28 22:11
     */
    @PostMapping("/verify")
    public ServerResponse<String> verifyCode(@RequestBody Map<String,String> map){
        String phoneName = "phone";
        String smsCodeName = "smsCodeName";
        if (!map.containsKey(phoneName)){
            log.info("手机号为空");
            return ServerResponse.createByErrorMessage("手机号为空");
        }
        if(!map.containsKey(smsCodeName)){
            log.info("验证码为空");
            return ServerResponse.createByErrorMessage("验证码为空");
        }
        String phone = map.get("phone");
        String smsCode = map.get("smsCode");
        return smsService.verifyCode(phone,smsCode);
    }

    /**
     * description: 通过token，返回用户个人信息
     *
     * @return ServerResponse<UserDetail>
     * @author 胡建华
     * Date:  2022/9/30 9:37
     */
    @GetMapping
    public ServerResponse<UserDetail> getUserDetail(){
        return userService.getUserDetail();
    }

    /**
     * description: 修改个人信息，包括昵称，年龄，性别，头像和邮箱
     *
     * @param userDetail : 用户信息
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/9/30 16:13
     */
    @PutMapping
    public ServerResponse<UserDetail> updateUserDetail(@RequestBody UserDetail userDetail){
        return userService.updateUserDetail(userDetail);
    }

    /**
     * description: 忘记密码，需要提供用户名，手机号，验证码，密码
     *
     * @param user:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/3 16:12
     */
    @PutMapping("/forget/password")
    public ServerResponse<String> forgetPassword(@RequestBody User user){
        return userService.forgetPassword(user);
    }

    /**
     * description: 忘记用户名，需要手机号和验证码
     *
     * @param userDetail:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/3 16:13
     */
    @PostMapping("/forget/username")
    public ServerResponse<Map<String,String>> forgetUsername(@RequestBody UserDetail userDetail){
        return userService.forgetUsername(userDetail);
    }

    /**
     * description: 修改手机号，需要旧手机号，新手机号，旧验证码，新验证码
     *
     * @param updateUser:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/3 20:59
     */
    @PutMapping("/phone")
    public ServerResponse<String> updatePhone(@RequestBody UpdateUser updateUser){
        return userService.updatePhone(updateUser);
    }

    /**
     * description: 修改密码，需要旧密码，新密码，手机号，验证码
     *
     * @param updateUser:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/3 21:00
     */
    @PutMapping("/password")
    public ServerResponse<String> updatePassword(@RequestBody UpdateUser updateUser){
        return userService.updatePassword(updateUser);
    }


}
