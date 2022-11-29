package com.sicnu.boot.controller;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.service.QuestionService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.QuestionSelective;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    /**
     * description: 通过id，获取具体题目信息
     *
     * @param questionId:
     * @return ServerResponse<Question>
     * @author 胡建华
     * Date:  2022/11/17 10:27
     */
    @GetMapping("/{questionId}")
    public ServerResponse<Question> getQuestionById(@Min(value = 0,message = "difficultId的最小值为0")
                                              @PathVariable Integer questionId){
        return questionService.getQuestionById(questionId);
    }

    /**
     * description: 题库组卷功能
     *
     * @param questionSelective:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/17 10:27
     */
    @PostMapping("/paper")
    public ServerResponse<List<Question>> getGeneratingPaper(@Validated @RequestBody QuestionSelective questionSelective){
        return questionService.getGeneratingPaper(questionSelective);
    }

    /**
     * description: 收藏题目，或取消收藏题目
     *
     * @param questionId:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/23 18:56
     */
    @PostMapping("/collect/{questionId}")
    ServerResponse<String> collectQuestion(@Min (value = 1,message = "题目id最小值为1")
                                        @PathVariable("questionId")Integer questionId){
        return questionService.collectQuestion(questionId);
    }

    /**
     * description: 获取用户的收藏列表
     *
     * @param pageNum :
     * @return ServerResponse<PageInfo<Video>>
     * @author 胡建华
     * Date:  2022/11/23 19:39
     */
    @GetMapping("/collect/{pageNum}-{userId}")
    ServerResponse<PageInfo<Question>> getCollectQuestionList(@Min(value = 1,message = "pageNum的最小值为1")
                                                        @PathVariable Integer pageNum,
                                                              @Min(value = 1,message = "userId的最小值为1")
                                                              @PathVariable Integer userId){
        return questionService.getCollectQuestionList(pageNum,userId);
    }
}
