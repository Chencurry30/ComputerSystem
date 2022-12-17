package com.sicnu.boot.mapper;


import com.sicnu.boot.pojo.College;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 蔡名展
 * @version 1.0
 * description:
 * @date 2022/10/13 14:49
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CollegeMapperTest {
    @Resource
    private CollegeMapper collegeMapper;

    @Test
    public void testGetById(){
        College college = collegeMapper.getCollegeById(1);
        System.out.println(college);
    }

    @Test
    public void testGetByName(){
        List<College> college = collegeMapper.getCollegeByName("院");
        System.out.println(college);
    }

    @Test
    public void testGetAllCollege(){
        List<College> allCollege = collegeMapper.getAllCollege();
        System.out.println(allCollege);
    }

}
