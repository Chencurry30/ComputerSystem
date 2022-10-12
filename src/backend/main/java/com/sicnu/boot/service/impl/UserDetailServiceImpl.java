package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.PowerMapper;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.vo.LoginUser;
import com.sicnu.boot.pojo.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * description:  用于判断用户是否登录成功
 *
 * @author :  胡建华
 * Data:    2022/09/26 19:27
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PowerMapper powerMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        User user = userMapper.getByUsername(username);
        //如果没有查询到用户就抛出异常
        if (Objects.isNull(user)){
            throw new RuntimeException("用户名或密码错误");
        }
        //查询对应的权限
        List<String> list = powerMapper.selectPermsByUserId(user.getUserId());
        //把数据封装成UserDetail对象
        return new LoginUser(user,list);
    }
}
