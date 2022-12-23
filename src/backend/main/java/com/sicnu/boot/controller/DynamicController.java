package com.sicnu.boot.controller;


import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Dynamic;
import com.sicnu.boot.service.DynamicService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.DynamicVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.constraints.Min;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/11/26 14:37
 */
@RestController
@RequestMapping("/dynamics")
@Validated
public class DynamicController {
    @Resource
    private DynamicService dynamicService;

    @PostMapping("")
    ServerResponse<String> addDynamic(@Validated @RequestBody Dynamic dynamic){
        return dynamicService.addDynamic(dynamic);
    }

    @DeleteMapping("/{dynamicId}")
    ServerResponse<String> deleteDynamic(@Min(value = 1,message = "id最小值为1")@PathVariable Integer dynamicId){
        return dynamicService.deleteDynamic(dynamicId);
    }

    @GetMapping("/users/{userId}/{pageNum}")
    ServerResponse<PageInfo<DynamicVo>> getDynamicByUserId(
            @Min(value = 1,message = "id最小值为1")@PathVariable Integer userId,
            @Min(value = 1,message = "id最小值为1")@PathVariable Integer pageNum){
        return dynamicService.getDynamicByUserId(userId,pageNum);
    }

    @GetMapping("/pages/{pageNum}")
    ServerResponse<PageInfo<DynamicVo>> getAllDynamic(@Min(value = 1,message = "id最小值为1")@PathVariable Integer pageNum){
        return dynamicService.getAllDynamic(pageNum);
    }
}
