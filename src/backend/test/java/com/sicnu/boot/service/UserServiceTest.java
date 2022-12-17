package com.sicnu.boot.service;

import com.sicnu.boot.utils.ServerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-11 9:45
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void testRegister(){
//        userService.register("admin1","123456");
    }

    @Test
    void testLogin(){
//        ServerResponse<Map<String,String>> admin1 = userService.login("admin12", "1234568");
//        System.out.println(admin1);
    }
}
