package com.sicnu.boot.service.impl;

import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.pojo.User;
import com.sicnu.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-09 20:26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ServerResponse<Map<String,String>> login(String username, String password) {
        //首先判断用户名是否存在
        Integer resultCount = userMapper.checkUsername(username);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        //取出该用户名对应的用户
        User user = userMapper.getByUsername(username);
        //判断该密码是否与加密密码一致
        if(!passwordEncoder.matches(password,user.getPassword())){
            //查询结果为空，密码错误
            return ServerResponse.createByErrorMessage("密码错误");
        }
        return ServerResponse.createBySuccessMessage("登录成功");
    }

    @Override
    public ServerResponse<String> register(String username, String password) {
        //首先判断用户名是否存在
        Integer resultCount = userMapper.checkUsername(username);
        if(resultCount == 1){
            return ServerResponse.createByErrorMessage("用户名已经存在，请重新注册");
        }
        //对密码进行加密
        password = passwordEncoder.encode(password);
        //返回数据库受影响的行数
        Integer affectRow = userMapper.register(username, password);
        if (affectRow == 0){
            return ServerResponse.createByErrorMessage("注册失败，请重新注册");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }

}
