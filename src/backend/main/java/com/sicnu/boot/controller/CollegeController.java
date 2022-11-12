package com.sicnu.boot.controller;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.College;
import com.sicnu.boot.service.CollegeService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.CollegeSelective;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

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
@Validated
public class CollegeController {

    @Resource
    private CollegeService collegeService;

    /**
     * 获取学校信息
     * @param id：学校id
     * @return College
     */
    @GetMapping("/{id}")
    public ServerResponse<College> getCollegeById(@Min(value = 0,message = "院校id最小值为1")
                                                      @PathVariable("id") Integer id){
        return collegeService.getCollegeById(id);
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
     * 查询学校信息
     * @param name：学校名
     * @return College
     */
    @GetMapping("/name")
    public ServerResponse<List<College>> getCollegeByName(@RequestBody String name){
        return collegeService.getCollegeByName(name);
    }

    /**
     * 返回学校筛选框
     * @return List
     */
    @GetMapping("/filterBox")
    ServerResponse<List<Map<String,Object>>> getFilterBox(){
        return collegeService.getFilterBox();
    }

    /**
     * 通过选择，返回学校列表
     * @param collegeName：学校名
     * @param regionId：地区id
     * @param typeId：类型id
     * @param attributeId：属性id
     * @param pageNum：页数
     * @return collegeSelective
     */
    @GetMapping("/pages/{regionId}-{typeId}-{attributeId}-{pageNum}")
    ServerResponse<PageInfo<College>> getCollegeListBySelective(
            String collegeName,
            @Min (value = 0,message = "地区id最小值为0") @PathVariable("regionId") Integer regionId,
            @Min (value = 0,message = "类型id最小值为0") @PathVariable("typeId") Integer typeId,
            @Min (value = 0,message = "属性id最小值为0") @PathVariable("attributeId") Integer attributeId,
            @Min (value = 1,message = "页数id最小值为1") @PathVariable("pageNum") Integer pageNum){
        return collegeService.getCollegeListBySelective(new CollegeSelective(collegeName,regionId,typeId,attributeId,pageNum));
    }

}
