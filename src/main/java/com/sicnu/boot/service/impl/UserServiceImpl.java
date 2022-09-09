package com.sicnu.boot.service.impl;

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
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }
}
