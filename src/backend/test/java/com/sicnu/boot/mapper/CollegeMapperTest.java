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

    @Test
    public void testGetByName(){
        List<College> college = collegeMapper.getCollegeByName("院");
        System.out.println(college);
    }

    @Test
    public void testDeleteById(){
        Integer deleteCollege = collegeMapper.deleteCollege(1);
        System.out.println(deleteCollege);
    }

    @Test
    public void testUpdateCollegeById(){
        College college = new College(2,"测试","测试123","测试123","测试123","测试",123,"测试");
        collegeMapper.updateCollegeById(college);
        System.out.println(college);
    }

    @Test
    public void testGetAllCollege(){
        List<College> allCollege = collegeMapper.getAllCollege();
        System.out.println(allCollege);
    }

}
