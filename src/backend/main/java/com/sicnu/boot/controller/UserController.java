package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.User;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.service.ISmsService;
import com.sicnu.boot.service.UserService;
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
            return ServerResponse.createByErrorMessage("手机号为空");
        }
        String phone = map.get("phone");
        return smsService.sendSmsCode(phone);
    }

    /**
     * description: 验证手机验证码
     *
     * @param phone:
     * @param code:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/9/28 22:11
     */
    @PostMapping("/verify")
    public ServerResponse<String> verifyCode(String phone,String code){
        return smsService.verifyCode(phone,code);
    }


}
