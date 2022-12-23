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

    /**
     * description: 通过题目分类，题目类型获取指定数量的题目
     *
     * @param classifyId:
     * @param questionType:
     * @param questionNum:
     * @return List<Question>
     * @author 胡建华
     * Date:  2022/11/17 10:38
     */
    List<Question> getGeneratingPaper(Integer classifyId,Integer questionType,Integer questionNum);

    /**
     * description: 查看该用户是否收藏题目
     *
     * @param userId:
     * @param questionId:
     * @return int
     * @author 胡建华
     * Date:  2022/11/26 10:35
     */
    int checkCollectQuestion(Integer userId, Integer questionId);

    /**
     * description: 取消收藏题目
     *
     * @param userId:
     * @param questionId:
     * @author 胡建华
     * Date:  2022/11/26 10:37
     */
    void deleteCollectQuestion(Integer userId, Integer questionId);

    /**
     * description: 收藏题目
     *
     * @param userId:
     * @param questionId:
     * @author 胡建华
     * Date:  2022/11/26 10:38
     */
    void collectQuestion(Integer userId, Integer questionId);

    /**
     * description: 获取收藏列表
     *
     * @param userId:
     * @return List<Question>
     * @author 胡建华
     * Date:  2022/11/26 10:38
     */
    List<Question> getCollectQuestionList(Integer userId);

    /**
     * description: 通过名字模糊搜索题目
     *
     * @param name:
     * @return null
     * @author 胡建华
     * Date:  2022/12/13 20:11
     */
    List<Question> getQuestionByName(String name);

    /**
     * description: 获取每种分类数量
     *
     * @param classifyId:
     * @return Integer
     * @author 胡建华
     * Date:  2022/12/21 9:26
     */
    Integer getQuestionCountsByClassify(Integer classifyId);
}
