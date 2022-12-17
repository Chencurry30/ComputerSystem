package com.sicnu.boot.test;

import com.sicnu.boot.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-15 10:05
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RedisDemoApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {
        //向redis中添加数据
        stringRedisTemplate.opsForValue().set("keys", "value值");
        //根据键值取出数据
        System.out.println(stringRedisTemplate.opsForValue().get("keys"));
    }

    @Test
    void testRedisUtils(){
//        redisUtils.set("key","value");

//        System.out.println(redisUtils.get("key"));
    }

}
