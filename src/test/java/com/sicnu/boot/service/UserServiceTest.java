package com.sicnu.boot.service;

import com.sicnu.boot.common.ServerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectName: computer-system
 * @package: com.sicnu.boot.service
 * @className: testUserService
 * @author: hjh
 * @description: TODO
 * @date: 2022-09-11 9:45
 * @version:
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void testRegister(){
        userService.register("admin1","123456");
    }

    @Test
    void testLogin(){
        ServerResponse admin1 = userService.login("admin12", "1234568");
        System.out.println(admin1);
    }
}
