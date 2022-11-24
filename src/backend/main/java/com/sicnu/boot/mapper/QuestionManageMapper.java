package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.pojo.QuestionChoice;
import org.apache.ibatis.annotations.Mapper;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/24 16:25
 */
@Mapper
public interface QuestionManageMapper {
    /**
     * description: 添加题目
     *
     * @param question:
     * @author 胡建华
     * Date:  2022/11/24 16:30
     */
    void insertQuestion(Question question);

    /**
     * description: 插入选择题
     *
     * @param questionChoice:
     * @author 胡建华
     * Date:  2022/11/24 19:56
     */
    void insertQuestionChoice(QuestionChoice questionChoice);

    /**
     * description: 查询题库分类
     *
     * @param classifyId:
     * @return String
     * @author 胡建华
     * Date:  2022/11/24 20:28
     */
    String getQuestionClassify(Integer classifyId);
}
