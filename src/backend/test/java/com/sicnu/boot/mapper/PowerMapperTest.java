package com.sicnu.boot.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/12 20:49
 */
@SpringBootTest
public class PowerMapperTest {
    @Resource
    private PowerMapper powerMapper;

    @Test
    void testPower(){
        List<String> list = powerMapper.selectPermsByUserId(2);
        list.forEach(System.out::println);
    }
}
