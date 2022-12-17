package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Major;
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
 * @date 2022/10/20 10:48
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MajorMapperTest {
    @Resource
    private MajorMapper majorMapper;

    @Test
    public void testGetById(){
        Major major = majorMapper.getMajorById(1);
        System.out.println(major);
    }

    @Test
    public void testGetByName(){
        Major major = majorMapper.getMajorByName("测");
        System.out.println(major);
    }

    @Test
    public void testGetAll(){
        List<Major> allMajor = majorMapper.getAllMajor();
        System.out.println(allMajor);
    }

    @Test
    public void testGetByCollegeId(){
        List<Major> majorList = majorMapper.getMajorListByCollegeId(1);
        System.out.println(majorList);
    }

    @Test
    public void testGetMajorListBySelective(){
        List<Major> majorList = majorMapper.getMajorListBySelective(1,1);
        System.out.println(majorList);
    }
}
