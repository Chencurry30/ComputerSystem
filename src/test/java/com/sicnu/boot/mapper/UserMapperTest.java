package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: computer-system
 * @package: com.sicnu.boot.mapper
 * @className: UserMapperTest
 * @author: hjh
 * @description: TODO
 * @date: 2022-09-09 20:51
 * @version:
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testLogin(){
        User admin = userMapper.login("admin", "123456");
        System.out.println(admin);
    }

}
