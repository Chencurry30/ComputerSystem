package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.College;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 蔡名展
 * @version 1.0
 * description:
 * @date 2022/10/13 14:49
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CollegeMapperTest {
    @Resource
    private CollegeMapper collegeMapper;

    @Test
    public void testAddCollege(){
        College college = new College(null,"测试","测试","测试","测试","测试",123,"测试");
        System.out.println(collegeMapper);
        collegeMapper.addCollege(college);
        System.out.println(college);
    }

    @Test
    public void testGetById(){
        College college = collegeMapper.getCollegeById(1);
        System.out.println(college);
    }

}
