package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.pojo.QuestionChoice;
import com.sicnu.boot.vo.QuestionClassify;
import com.sicnu.boot.vo.QuestionSelective;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/09 19:12
 */
@Mapper
public interface QuestionMapper {
    /**
     * description: 通过题目分类，获取题目列表
     *
     * @param questionSelective:
     * @return List<Question>
     * @author 胡建华
     * Date:  2022/11/9 19:52
     */
    List<Question> getQuestionList(QuestionSelective questionSelective);

    /**
     * description: 通过题目id，获取选择题选项列表
     *
     * @param questionId:
     * @return List<QuestionChoice>
     * @author 胡建华
     * Date:  2022/11/9 19:54
     */
    List<QuestionChoice> getQuestionChoiceByQuestionId(Integer questionId);

    /**
     * description: 获取题库分类选择列表
     *
     * @return List<QuestionClassify>
     * @author 胡建华
     * Date:  2022/11/16 8:38
     */
    List<QuestionClassify> getQuestionClassifyList();

    /**
     * description: 通过id，获取题目信息
     *
     * @param questionId:
     * @return Question
     * @author 胡建华
     * Date:  2022/11/16 16:05
     */
    Question getQuestionById(Integer questionId);
}
