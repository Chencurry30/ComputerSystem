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
 * Data:    2022/10/27 10:55
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleMapperTest {
    @Resource
    private RoleMapper roleMapper;

    @Test
    void testGetMenuListByRoleId(){
        List<Menu> list = roleMapper.getMenuListByRoleId(2);
        list.forEach(System.out::println);
    }
}
