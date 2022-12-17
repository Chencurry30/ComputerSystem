package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Question;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/09 19:55
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuestionMapperTest {

    @Test
    void testGetQuestionList(){
        List<Question> randoms = createRandoms(new ArrayList<>(), 1);
        System.out.println(randoms);
        randoms = createRandoms(new ArrayList<>(), 3);
        System.out.println(randoms);
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
