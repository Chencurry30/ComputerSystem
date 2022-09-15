package com.sicnu.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * description:  配置类
 * @author :     胡建华
 * Data: 2022-09-11 9:10
 */
@Configuration
public class BeanConfig {

    /**
     * description: 添加对密码加密的bean
     *
     * @return PasswordEncoder
     * @author 胡建华
     * Date:  2022/9/15 18:58
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(6);
    }



}
