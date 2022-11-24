package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.utils.ServerResponse;

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
}
