package com.sicnu.boot.controller;


import com.sicnu.boot.pojo.Teacher;
import com.sicnu.boot.service.TeacherService;
import com.sicnu.boot.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * description:
 *
 * @author 汪杨
 * @version 1.0
 * @date 2022/11/2
 */
@Slf4j
@RestController
@RequestMapping("/teachers")
@Validated
public class TeacherController {

    @Resource
    private TeacherService teacherService;
    @GetMapping("/{id}")
    public ServerResponse<Teacher> getTeacherById(@PathVariable("id") Integer id){
        return teacherService.getTeacherById(id);
    }

}
