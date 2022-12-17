package com.sicnu.boot.service;

import com.sicnu.boot.pojo.College;
import com.sicnu.boot.vo.CollegeSelective;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/14 13:57
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CollegeServiceTest {
    @Resource
    private CollegeService collegeService;

    @Test
    public void testGetCollegeById(){
        System.out.println(collegeService.getCollegeById(2));
    }

    @Test
    public void testGetCollegeByName(){
        System.out.println(collegeService.getCollegeByName("院"));
    }

    @Test
    public void testGetCollegePage(){
        System.out.println(collegeService.getCollegePage(2));
    }

    @Test
    public void testGetFilterBox(){
        System.out.println(collegeService.getFilterBox());
    }

    @Test
    public void testGetCollegeListBySelective(){
        CollegeSelective collegeSelective = new CollegeSelective("null",0,0,0,1);
        System.out.println(collegeService.getCollegeListBySelective(collegeSelective));
    }
}
