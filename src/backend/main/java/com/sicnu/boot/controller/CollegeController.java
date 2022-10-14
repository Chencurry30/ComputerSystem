package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.College;
import com.sicnu.boot.service.CollegeService;
import com.sicnu.boot.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/14 13:49
 */
@Slf4j
@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Resource
    private CollegeService collegeService;

    /**
     * 获取学校信息
     * @param id：学校id
     * @return College
     */
    @GetMapping("/{id}")
    public ServerResponse<College> getCollegeById(@PathVariable("id") Integer id){
        return collegeService.getCollegeById(id);
    }
}
