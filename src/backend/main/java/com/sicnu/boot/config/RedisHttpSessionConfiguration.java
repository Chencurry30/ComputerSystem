package com.sicnu.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/11/19 21:25
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
public class RedisHttpSessionConfiguration {
}
