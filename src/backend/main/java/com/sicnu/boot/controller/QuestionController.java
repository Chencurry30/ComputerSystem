package com.sicnu.boot.controller;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.service.QuestionService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.QuestionSelective;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/15 22:06
 */
@RestController
@Validated
@RequestMapping("/question")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    /**
     * description: 获取题库列表
     *
     * @param typeId:
     * @param difficultId:
     * @param classifyId:
     * @param sourceId:
     * @param yearId:
     * @param pageNum:
     * @return ServerResponse<PageInfo<Question>>
     * @author 胡建华
     * Date:  2022/11/16 15:34
     */
    @GetMapping("/pages/{typeId}-{difficultId}-{classifyId}-{sourceId}-{yearId}-{pageNum}")
    public ServerResponse<PageInfo<Question>> getQuestionList(@Min(value = 0,message = "typeId的最小值为0") @PathVariable Integer typeId,
                                              @Min(value = 0,message = "difficultId的最小值为0") @PathVariable Integer difficultId,
                                              @Min(value = 0,message = "classifyId的最小值为0") @PathVariable Integer classifyId,
                                              @Min(value = 0,message = "sourceId的最小值为0") @PathVariable Integer sourceId,
                                              @Min(value = 0,message = "yearId的最小值为0") @PathVariable Integer yearId,
                                              @Min(value = 1,message = "分页数最小为1") @PathVariable Integer pageNum ){

        return questionService.getQuestionList(new QuestionSelective(typeId,difficultId,classifyId,sourceId,yearId,pageNum));
    }

    /**
     * description: 获取题库选择框
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/16 8:41
     */
    @GetMapping("/filterBox")
    public ServerResponse<List<Map<String,Object>>> getFilterBox(){
        return questionService.getFilterBox();
    }

    @GetMapping("/{questionId}")
    public ServerResponse<Question> getQuestionById(@Min(value = 0,message = "difficultId的最小值为0")
                                              @PathVariable Integer questionId){
        return questionService.getQuestionById(questionId);
    }
}
