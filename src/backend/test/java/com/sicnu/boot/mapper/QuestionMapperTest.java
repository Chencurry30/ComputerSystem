package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.pojo.QuestionChoice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/09 19:55
 */
@SpringBootTest
public class QuestionMapperTest {
    @Resource
    private QuestionMapper questionMapper;

    @Test
    void testGetQuestionList(){
        List<Question> questionList = questionMapper.getQuestionList(5);
        for (Question question : questionList) {
            List<QuestionChoice> choice = questionMapper.getQuestionChoiceByQuestionId(question.getQuestionId());
            question.setQuestionChoiceList(choice);
        }
        List<Question> questionList1 = createRandoms(questionList, 10);
        createRandoms(questionList, 12);
        questionList1.forEach(System.out :: println);
    }

    private List<Question> createRandoms(List<Question> list, int n) {
        Map<Integer,String> map = new HashMap<>();
        List<Question> news = new ArrayList<>();
        if (list.size() <= n) {
            return list;
        } else {
            while (map.size() < n) {
                int random = (int)(Math.random() * list.size());
                if (!map.containsKey(random)) {
                    map.put(random, " ");
                    news.add(list.get(random));
                }
            }
            return news;
        }
    }
}
