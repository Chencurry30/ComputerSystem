package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.User;
import com.sicnu.boot.vo.UserDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-09 20:51
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testLogin(){
        User admin = userMapper.getByUsername("admin");
        System.out.println(admin);
    }

    @Test
    void testCheckUsername(){
        Integer admin = userMapper.checkUsername("admin");
        System.out.println(admin);
    }

    @Test
    void testCheckPhone(){
        Integer integer = userMapper.checkPhone("13541169382");
        System.out.println(integer);
    }

    @Test
    void testUpdateUser(){
        UserDetail userDetail = new UserDetail(null,"大海",18,
                "116427542","224456434@qq.com","头像","男",null,0,"");
        User user = new User(3,userDetail);
        Integer integer = userMapper.updateUser(user);
        System.out.println(integer);
    }

    @Test
    void testUpdatePasswordByUsername(){
        userMapper.updatePasswordByUsername("czy","1234");
    }

    @Test
    void testGetUsernameByPhone(){
        String username = userMapper.getUsernameByPhone("17311023002");
        System.out.println(username);
    }

}
