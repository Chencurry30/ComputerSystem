package com.sicnu.boot.service;

import com.sicnu.boot.pojo.College;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/14 13:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CollegeServiceTest {
    @Resource
    private CollegeService collegeService;

    @Test
    public void testGetCollegeById(){
        System.out.println(collegeService.getCollegeById(2));
    }

    @Test
    public void testAddCollege(){
        College college = new College(null,"测试1","测试1","测试1","测试1","测试1",999,"测试1");
        System.out.println(collegeService.addCollege(college));
    }
}
