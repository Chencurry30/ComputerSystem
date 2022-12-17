package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Dynamic;
import com.sicnu.boot.vo.DynamicVo;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DynamicMapperTest {
    @Resource
    private DynamicMapper dynamicMapper;

    @Test
    public void testGetDynamicByUserId(){
        List<DynamicVo> dynamicList = dynamicMapper.getDynamicByUserId(2);
        System.out.println(dynamicList);
    }
}
