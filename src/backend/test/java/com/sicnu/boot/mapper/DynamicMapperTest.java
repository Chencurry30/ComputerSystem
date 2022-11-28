package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Dynamic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/11/26 16:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DynamicMapperTest {
    @Resource
    private DynamicMapper dynamicMapper;

    @Test
    public void testGetDynamicByUserId(){
        List<Dynamic> dynamicList = dynamicMapper.getDynamicByUserId(2);
        System.out.println(dynamicList);
    }
}
