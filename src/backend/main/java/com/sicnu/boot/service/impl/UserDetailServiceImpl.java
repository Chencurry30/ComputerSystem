package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.MenuMapper;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.vo.LoginUser;
import com.sicnu.boot.pojo.User;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        User user = userMapper.getByUsername(username);
        //如果没有查询到用户就抛出异常
        if (Objects.isNull(user)){
            log.error("登录用户时，登录失败，失败原因：无法从数据库中查询到该用户");
            throw new RuntimeException("用户名或密码错误");
        }
        List<Menu> menus = userMapper.getUserMenu(user.getUserId());
        List<String> list = new ArrayList<>();
        for (Menu menu : menus) {
            if (!Objects.isNull(menu.getPerms())){
                list.add(menu.getPerms());
            }
        }
        //把数据封装成UserDetail对象
        return new LoginUser(user,list);
    }
}
