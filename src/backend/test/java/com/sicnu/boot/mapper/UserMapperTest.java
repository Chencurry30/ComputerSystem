package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-09 20:51
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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

    }

    @Test
    void testUpdatePasswordByUsername(){
        userMapper.updatePasswordByUsername("czy","1234");
    }

    @Test
    void testGetUsernameByPhone(){
        String username = userMapper.getUsernameByPhone("13541169382");
        System.out.println(username);
    }

}
