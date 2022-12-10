package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.TeacherExamine;
import com.sicnu.boot.service.TeacherExamineService;
import com.sicnu.boot.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/examine")
@Validated
public class TeacherExamineController {
    @Resource
    private TeacherExamineService teacherExamineService;

    @GetMapping
    public ServerResponse<List<TeacherExamine>> getAllExamine(){
        return teacherExamineService.getAllExamine();
    }

    @PostMapping()
    ServerResponse<String> insertExamine(@Validated @RequestBody TeacherExamine examine){
        return teacherExamineService.insertExamine(examine);
    }
    @PutMapping("/agree/{userId}")
    ServerResponse<String> updateExamine(@Validated
                                         @PathVariable Integer userId){
        return teacherExamineService.updateAgrExamine(userId);
    }

    @PutMapping("/disagree/{userId}")
    ServerResponse<String> updateDisAgrExamine(@Validated
                                               @PathVariable Integer userId){
        return teacherExamineService.updateDisAgrExamine(userId);
    }
}
