package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.User;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.service.ISmsService;
import com.sicnu.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * description:
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

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/login")
    public ServerResponse<Map<String,String>> login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/register")
    public ServerResponse<String> register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/sms")
    public ServerResponse<String> sendSms(@RequestBody Map<String,String> map){
        if (!map.containsKey("phone")){
            return ServerResponse.createByErrorMessage("手机号为空");
        }
        String phone = map.get("phone");
        return smsService.sendSmsCode(phone);
    }

    @PostMapping("/verify")
    public ServerResponse<String> verifyCode(String phone,String code){
        return smsService.verifyCode(phone,code);
    }
}
