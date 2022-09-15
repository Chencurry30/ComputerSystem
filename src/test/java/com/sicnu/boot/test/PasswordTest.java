package com.sicnu.boot.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-11 9:19
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
