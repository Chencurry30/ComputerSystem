package com.sicnu.boot.controller;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.group.Insert;
import com.sicnu.boot.group.Update;
import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.service.QuestionManageService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.QuestionSelective;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;

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

    /**
     * description: 新增题库
     *
     * @param question:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/25 20:40
     */
    @PostMapping
    @PreAuthorize("hasAuthority('system:question:insert')")
    ServerResponse<String> insertQuestion(@Validated(Insert.class) @RequestBody Question question){
        return questionManageService.insertQuestion(question);
    }

    /**
     * description: 编辑题目
     *
     * @param question:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/25 21:00
     */
    @PutMapping
    @PreAuthorize("hasAuthority('system:question:update')")
    ServerResponse<String> updateQuestion(@Validated(Update.class) @RequestBody Question question){
        return questionManageService.updateQuestion(question);
    }

    /**
     * description: 删除指定题目
     *
     * @param questionId:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/26 9:45
     */
    @DeleteMapping("/{questionId}")
    @PreAuthorize("hasAuthority('system:question:delete')")
    ServerResponse<String> deleteQuestionById(@Min(value = 1,message = "题目id最小为1")
                                  @PathVariable Integer questionId){
        return questionManageService.deleteQuestionById(questionId);
    }

    /**
     * description: 获取指定题目信息
     *
     * @param questionId:
     * @return ServerResponse<Question>
     * @author 胡建华
     * Date:  2022/11/26 9:46
     */
    @GetMapping("/{questionId}")
    @PreAuthorize("hasAuthority('system:question:view')")
    ServerResponse<Question> getQuestionInfoById(@Min(value = 1,message = "题目id最小为1")
                                       @PathVariable Integer questionId){
        return questionManageService.getQuestionInfoById(questionId);
    }

    /**
     * description: 获取题目列表
     *
     * @param questionName:
     * @param classifyId:
     * @param sourceId:
     * @param pageNum:
     * @return ServerResponse<PageInfo<Question>>
     * @author 胡建华
     * Date:  2022/11/26 9:46
     */
    @GetMapping("/pages/{classifyId}-{sourceId}-{pageNum}")
    @PreAuthorize("hasAuthority('system:question:view')")
    ServerResponse<PageInfo<Question>> getQuestionList(
            @Length(max = 20,message = "视频名字的最大值为20") String questionName,
            @Min(value = 0,message = "classifyId的最小值为0") @PathVariable Integer classifyId,
            @Min(value = 0,message = "sourceId的最小值为0") @PathVariable Integer sourceId,
            @Min(value = 1,message = "分页数最小为1") @PathVariable Integer pageNum){
        QuestionSelective questionSelective = new QuestionSelective(questionName,classifyId,sourceId,pageNum);
        return questionManageService.getQuestionList(questionSelective);
    }
}
