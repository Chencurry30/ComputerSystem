package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.pojo.QuestionChoice;
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
     * @param questionClassify:
     * @return List<Question>
     * @author 胡建华
     * Date:  2022/11/9 19:52
     */
    List<Question> getQuestionList(Integer questionClassify);

    /**
     * description: 通过题目id，获取选择题选项列表
     *
     * @param questionId:
     * @return List<QuestionChoice>
     * @author 胡建华
     * Date:  2022/11/9 19:54
     */
    List<QuestionChoice> getQuestionChoiceByQuestionId(Integer questionId);
}
