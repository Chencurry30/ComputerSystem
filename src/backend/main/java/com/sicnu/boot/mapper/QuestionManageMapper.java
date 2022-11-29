package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.pojo.QuestionChoice;
import com.sicnu.boot.vo.QuestionSelective;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * description: 编辑题目
     *
     * @param question:
     * @author 胡建华
     * Date:  2022/11/25 20:51
     */
    void updateQuestion(Question question);

    /**
     * description: 修改题目选项
     *
     * @param questionChoice:
     * @author 胡建华
     * Date:  2022/11/25 20:57
     */
    void updateQuestionChoice(QuestionChoice questionChoice);

    /**
     * description: 获取具体题目
     *
     * @param questionId:
     * @return Question
     * @author 胡建华
     * Date:  2022/11/26 9:27
     */
    Question getQuestionInfoById(Integer questionId);

    /**
     * description: 获取题目的类型
     *
     * @param questionId:
     * @return Integer
     * @author 胡建华
     * Date:  2022/11/26 9:29
     */
    Integer checkQuestionType(Integer questionId);

    /**
     * description: 删除题目选项
     *
     * @param questionId:
     * @author 胡建华
     * Date:  2022/11/26 9:32
     */
    void deleteQuestionChoice(Integer questionId);

    /**
     * description: 删除指定题目
     *
     * @param questionId:
     * @author 胡建华
     * Date:  2022/11/26 9:33
     */
    void deleteQuestionById(Integer questionId);

    /**
     * description: 获取题库列表
     *
     * @param questionSelective:
     * @return List<Question>
     * @author 胡建华
     * Date:  2022/11/26 9:39
     */
    List<Question> getQuestionList(QuestionSelective questionSelective);

    /**
     * description: 获取题目选项列表
     *
     * @param questionId:
     * @return List<QuestionChoice>
     * @author 胡建华
     * Date:  2022/11/26 9:44
     */
    List<QuestionChoice> getQuestionChoiceByQuestionId(Integer questionId);
}
