package com.sicnu.boot.service.impl;

import com.sicnu.boot.service.ISmsService;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.vo.LoginUser;
import com.sicnu.boot.utils.JwtUtil;
import com.sicnu.boot.utils.RedisUtils;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.pojo.User;
import com.sicnu.boot.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-09 20:26
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private ISmsService smsService;

    @Override
    public ServerResponse<Map<String,Object>> login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //认证失败，抛出异常
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getUserId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisUtils.setCacheObject("login:"+userId,loginUser);
        //把token响应给前端
        HashMap<String,Object> map = new HashMap<>(5);
        map.put("token",jwt);
        //返回用户部分信息
        Map<String,String> map1 = new HashMap<>(5);
        map1.put("nickname",loginUser.getUser().getNickname());
        map1.put("image",loginUser.getUser().getImage());
        map.put("user",map1);
        return ServerResponse.createBySuccess("登录成功",map);
    }

    @Override
    public ServerResponse<String> register(User user) {
        //检查手机号是否存在
        Integer checkPhone = userMapper.checkPhone(user.getPhone());
        if (checkPhone == 1){
            return ServerResponse.createByErrorMessage("手机号已存在，请重新注册");
        }
        //验证手机验证码是否正确
        ServerResponse<String> verifyCodeResponse = smsService.verifyCode(user.getPhone(), user.getSmsCode());
        if (verifyCodeResponse.getCode() != ResponseCode.SUCCESS.getCode()){
            return ServerResponse.createByErrorMessage("验证码错误，请重新输入验证码");
        }
        //首先判断用户名是否存在
        Integer checkUsername = userMapper.checkUsername(user.getUsername());
        if(checkUsername == 1){
            return ServerResponse.createByErrorMessage("用户名已经存在，请重新注册");
        }
        //对密码进行加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //返回数据库受影响的行数
        Integer affectRow = userMapper.register(user);
        if (affectRow == 0){
            return ServerResponse.createByErrorMessage("注册失败，请重新注册");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }

    @Override
    public ServerResponse<String> logout() {
        //获取SecurityContextHolder中的用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getUserId();
        //删除redis的值
        redisUtils.deleteObject("login:"+userid);
        return ServerResponse.createBySuccessMessage("退出成功");
    }

}
