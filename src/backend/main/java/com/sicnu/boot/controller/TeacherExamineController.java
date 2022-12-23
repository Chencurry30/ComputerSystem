package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.TeacherExamine;
import com.sicnu.boot.service.TeacherExamineService;
import com.sicnu.boot.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author 汪杨
 * @version 1.0
 * @date 2022/11/2
 */
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
    @PutMapping("/agree/{examineId}")
    ServerResponse<String> updateExamine(@Validated
                                         @PathVariable Integer examineId){
        return teacherExamineService.updateAgrExamine(examineId);
    }

    @PutMapping("/disagree/{examineId}/{reviewComment}")
    ServerResponse<String> updateDisAgrExamine(@Validated
                                               @PathVariable Integer examineId,@PathVariable String reviewComment){
        return teacherExamineService.updateDisAgrExamine(examineId,reviewComment);
    }
}
