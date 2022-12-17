package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Menu;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuMapperTest {
    @Resource
    private MenuMapper powerMapper;

    @Test
    void testPower(){
        List<Menu> list = powerMapper.getMenuList();
        list.forEach(System.out::println);
    }
}
