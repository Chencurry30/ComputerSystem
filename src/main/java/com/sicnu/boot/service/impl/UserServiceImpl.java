package com.sicnu.boot.service.impl;

import com.sicnu.boot.common.ServerResponse;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.pojo.User;
import com.sicnu.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @projectName: computer-system
 * @package: com.sicnu.boot.service.impl
 * @className: UserServiceImpl
 * @author: hjh
 * @description: TODO
 * @date: 2022-09-09 20:26
 * @version:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse login(String username, String password) {
        Integer resultCount = userMapper.checkUsername(username);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        User user = userMapper.login(username, password);
        if(user == null){
            //查询结果为空，密码错误
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPassword("");
        return ServerResponse.createBySuccessMessage("登录成功");
    }

}
