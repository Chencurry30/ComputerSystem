package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Major;
import com.sicnu.boot.utils.ServerResponse;
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
 * @date 2022/11/15 22:48
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MajorServiceTest {
    @Resource
    private MajorService majorService;

    @Test
    public void testGetMajorListBySelective(){
        ServerResponse<List<Major>> list = majorService.getMajorListBySelective(1, 1);
        System.out.println(list);
    }

}
