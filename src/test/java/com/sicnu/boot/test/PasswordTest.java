package com.sicnu.boot.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @projectName: computer-system
 * @package: com.sicnu.boot.test
 * @className: PasswordTest
 * @author: hjh
 * @description: TODO
 * @date: 2022-09-11 9:19
 * @version:
 */
@SpringBootTest
public class PasswordTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testPasswordEncoder(){
        String encode = passwordEncoder.encode("123");
        System.out.println(encode);

        System.out.println(passwordEncoder.matches("123", encode));
    }
}
