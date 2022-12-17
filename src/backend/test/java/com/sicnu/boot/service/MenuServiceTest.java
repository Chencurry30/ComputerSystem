package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.utils.ServerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 9:33
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuServiceTest {
    @Resource
    private MenuService menuService;

    @Test
    void testGetMenuTree(){
        long begin = System.currentTimeMillis();
        ServerResponse<List<Menu>> menuTree = menuService.getMenuTree();
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
        System.out.println("menuTree.getData() = " + menuTree.getData());
    }
}
