package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.TeacherQuestion;
import com.sicnu.boot.service.TeacherQuestionService;
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
 * @date 2022/11/23 21:49
 */

@Slf4j
@RestController
@RequestMapping("/teacherQuestion")
@Validated
public class TeacherQuestionController {
    @Resource
    TeacherQuestionService teacherQuestionService;

    @GetMapping("/questions/{id}")
    public ServerResponse<List<TeacherQuestion>> getTeacherQuestionById(@PathVariable("id") Integer id){
        return teacherQuestionService.getTeacherQuestionById(id);
    }

    @PostMapping
    ServerResponse<String> insertTeacherQuestion(@Validated @RequestBody TeacherQuestion teacher){
        return teacherQuestionService.insertTeacherQuestion(teacher);
    }

    @GetMapping("/answers/{id}")
    public ServerResponse<List<TeacherQuestion>> getTeacherAnswerById(@PathVariable("id") Integer id){
        return teacherQuestionService.getTeacherAnswerById(id);
    }

    @PutMapping("/{id}")
    ServerResponse<String> updateTeacherAnswer(@PathVariable("id") @Validated @RequestBody Integer id){
        return teacherQuestionService.updateTeacherAnswer(id);
    }
}
