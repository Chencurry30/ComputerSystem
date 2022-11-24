package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.service.QuestionManageService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/24 16:24
 */
@RestController
@RequestMapping("/admin/question")
@Validated
public class QuestionManageController {

    @Resource
    private QuestionManageService questionManageService;

    @PostMapping
    ServerResponse<String> insertQuestion(@Validated @RequestBody Question question){
        return questionManageService.insertQuestion(question);
    }
}
