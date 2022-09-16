package com.sicnu.boot.controller;

import com.sicnu.boot.common.ServerResponse;
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
@RequestMapping("/api/users")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private ISmsService smsService;

    @PostMapping("/login")
    public ServerResponse<Map<String,String>> login(String username, String password, HttpSession session){
        ServerResponse<Map<String,String>> response = userService.login(username, password);
        if(response.isSuccess()){
            //判断是否成功登录，如果成功，存放token
            Map<String,String> map = new HashMap<>();
            map.put("token",session.getId());
            return ServerResponse.createBySuccess("登录成功",map);
        }
        log.info("username:{}, password:{}, data:{}", username, password, response.getData());
        return response;
    }

    @PostMapping("/register")
    public ServerResponse<String> register(String username,String password){
        return userService.register(username, password);
    }

    @PostMapping("/sms")
    public ServerResponse<String> sendSms(String phone){
        return smsService.sendSmsCode(phone);
    }

    @PostMapping("/verify")
    public ServerResponse<String> verifyCode(String phone,String code){
        return smsService.verifyCode(phone,code);
    }
}
