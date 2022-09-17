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
    public ServerResponse<Map<String,String>> login(@RequestBody Map<String,String> map, HttpSession session){
        //通过map集合获取json数据
        if(!map.containsKey("username")){
            return ServerResponse.createByErrorMessage("用户名为空");
        }else if (!map.containsKey("password")){
            return ServerResponse.createByErrorMessage("密码为空");
        }
        //取出username和password
        String username = map.get("username");
        String password = map.get("password");
        ServerResponse<Map<String,String>> response = userService.login(username, password);
        if(response.isSuccess()){
            //判断是否成功登录，如果成功，存放token
            Map<String,String> res = new HashMap<>();
            res.put("token",session.getId());
            return ServerResponse.createBySuccess("登录成功",res);
        }
        log.info("username:{}, password:{}, data:{}", username, password, response.getData());
        return response;
    }

    @PostMapping("/register")
    public ServerResponse<String> register(@RequestBody Map<String,String> map){
        //通过map集合获取json数据
        if(!map.containsKey("username")){
            return ServerResponse.createByErrorMessage("用户名为空");
        }else if (!map.containsKey("password")){
            return ServerResponse.createByErrorMessage("密码为空");
        }
        //取出username和password
        String username = map.get("username");
        String password = map.get("password");
        return userService.register(username, password);
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
