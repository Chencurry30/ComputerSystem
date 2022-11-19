package com.sicnu.boot.test;

import com.sicnu.boot.config.OssProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-11 9:19
 */
@SpringBootTest
public class PasswordTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private OssProperties ossProperties;

    @Test
    void testPasswordEncoder(){
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
//        System.out.println(passwordEncoder.matches("123", encode));
        System.out.println(ossProperties.getHost());
    }
}
