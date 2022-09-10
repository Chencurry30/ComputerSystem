package com.sicnu.boot.controller;

import com.sicnu.boot.common.ServerResponse;
import com.sicnu.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: computer-system
 * @package: com.sicnu.boot.controller
 * @className: UserController
 * @author: hjh
 * @description: TODO
 * @date: 2022-09-09 20:31
 * @version:
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ServerResponse login(String username, String password, HttpSession session){
        ServerResponse response = userService.login(username, password);
        if(response.isSuccess()){
            //判断是否成功登录，如果成功，存放token
            Map<String,String> map = new HashMap<>();
            map.put("token",session.getId());
            response = ServerResponse.createBySuccess(map);
        }
        log.info("username:{}, password:{}, data:{}", username, password, response.getData());
        return response;
    }

}
