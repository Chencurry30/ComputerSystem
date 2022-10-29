package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.Major;
import com.sicnu.boot.service.MajorService;
import com.sicnu.boot.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/20 11:22
 */

@Slf4j
@RestController
@RequestMapping("/majors")
public class MajorController {
    @Resource
    private MajorService majorService;

    /**
     * 查询专业信息
     * @param id：专业id
     * @return Major
     */
    @GetMapping("/{id}")
    public ServerResponse<Major> getMajorById(@PathVariable("id") Integer id){
        return majorService.getMajorById(id);
    }

    /**
     * 查询专业信息
     * @param name：专业名
     * @return Major
     */
    @GetMapping("/name")
    public ServerResponse<Major> getMajorByName(@RequestBody String name){
        return majorService.getMajorByName(name);
    }

    /**
     * 查询所有专业
     * @return List
     */
    @GetMapping
    public ServerResponse<List<Major>> getAllMajor(){
        return majorService.getAllMajor();
    }

    /**
     * 分页查询
     * @param pageNum：页码数
     * @return Page
     */
    @GetMapping("/pages/{pageNum}")
    public ServerResponse<List<Major>> getMajorPage(@PathVariable Integer pageNum){
        return majorService.getMajorPage(pageNum);
    }

    /**
     * 通过学校id查找专业
     */
    @GetMapping("/colleges/{collegeId}")
    public ServerResponse<List<Major>> getMajorListByCollegeId(@PathVariable Integer collegeId){
        return majorService.getMajorListByCollegeId(collegeId);
    }
}
