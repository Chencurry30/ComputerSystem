package com.sicnu.boot.service;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.QuestionSelective;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/24 16:25
 */
public interface QuestionManageService {
    /**
     * description: 添加题目
     *
     * @param question :
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/24 16:29
     */
    ServerResponse<String> insertQuestion(Question question);

    /**
     * description: 修改题目
     *
     * @param question:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/25 20:41
     */
    ServerResponse<String> updateQuestion(Question question);

    /**
     * description: 删除题目
     *
     * @param questionId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/25 22:48
     */
    ServerResponse<String> deleteQuestionById(Integer questionId);

    /**
     * description: 获取题目信息
     *
     * @param questionId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/25 22:48
     */
    ServerResponse<Question> getQuestionInfoById(Integer questionId);

    /**
     * description: 获取题目列表
     *
     * @param questionSelective:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/25 22:49
     */
    ServerResponse<PageInfo<Question>> getQuestionList(QuestionSelective questionSelective);
}
