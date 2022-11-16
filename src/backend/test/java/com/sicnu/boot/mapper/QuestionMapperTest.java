package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.pojo.QuestionChoice;
import com.sicnu.boot.vo.QuestionSelective;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
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

        QuestionSelective questionSelective = new QuestionSelective(null,3,null,
                BigDecimal.valueOf(0.3), BigDecimal.valueOf(0.6),2,
                null,"408",null,new Date(),null);
        List<Question> questionList = questionMapper.getQuestionList(questionSelective);
        questionList.forEach(System.out :: println);
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
