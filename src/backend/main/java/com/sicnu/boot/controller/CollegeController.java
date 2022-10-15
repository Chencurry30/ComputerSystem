package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.College;
import com.sicnu.boot.service.CollegeService;
import com.sicnu.boot.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


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

    /**
     * 添加学校
     * @param college：学校信息
     * @return College
     */
    @PostMapping
    public ServerResponse<College> addCollege(@RequestBody College college){
        return collegeService.addCollege(college);
    }

    /**
     * 删除学校
     * @param id：学校id
     * @return Integer
     */
    @DeleteMapping("/{id}")
    public ServerResponse<Integer> deleteCollege(@PathVariable("id") Integer id){
        return collegeService.deleteCollege(id);
    }

    /**
     * 查询所有学校
     * @return List
     */
    @GetMapping
    public ServerResponse<List<College>> getAllCollege(){
        return collegeService.getAllCollege();
    }

    /**
     * 更新学校
     * @param college：学校信息
     * @return College
     */
    @PutMapping
    public ServerResponse<College> updateCollege(@RequestBody College college){
        return collegeService.updateCollege(college);
    }

    /**
     * 查询学校信息
     * @param name：学校名
     * @return College
     */
    @GetMapping("/name")
    public ServerResponse<List<College>> getCollegeByName(@RequestBody String name){
        return collegeService.getCollegeByName(name);
    }
}
