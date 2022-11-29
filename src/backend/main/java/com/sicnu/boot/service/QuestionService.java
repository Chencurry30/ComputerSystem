package com.sicnu.boot.service;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.QuestionSelective;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/15 22:06
 */
public interface QuestionService {
    /**
     * description: 获取题目分类选择框
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/16 8:41
     */
    ServerResponse<List<Map<String,Object>>> getFilterBox();

    /**
     * description: 获取题目分页列表
     *
     * @param questionSelective:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/16 9:18
     */
    ServerResponse<PageInfo<Question>> getQuestionList(QuestionSelective questionSelective);

    /**
     * description: 通过id，获取题目具体信息
     *
     * @param questionId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/16 16:04
     */
    ServerResponse<Question> getQuestionById(Integer questionId);

    /**
     * description: 题库组卷功能
     *
     * @param questionSelective:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/17 10:27
     */
    ServerResponse<List<Question>> getGeneratingPaper(QuestionSelective questionSelective);

    /**
     * description: 收藏或取消收藏题目
     *
     * @param questionId:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/26 10:30
     */
    ServerResponse<String> collectQuestion(Integer questionId);

    /**
     * description: 获取用户的收藏列表
     *
     * @param pageNum :
     * @param userId :
     * @return ServerResponse<PageInfo<Video>>
     * @author 胡建华
     * Date:  2022/11/26 10:31
     */
    ServerResponse<PageInfo<Question>> getCollectQuestionList(Integer pageNum, Integer userId);
}
