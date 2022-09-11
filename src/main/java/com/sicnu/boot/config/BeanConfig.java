package com.sicnu.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @projectName: computer-system
 * @package: com.sicnu.boot.config
 * @className: BeanConfig
 * @author: hjh
 * @description: TODO
 * @date: 2022-09-11 9:10
 * @version:
 */
@Configuration
public class BeanConfig {

    /**
     * 添加对密码加密的bean
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(6);
    }

}
