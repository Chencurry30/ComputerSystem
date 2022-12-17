package com.sicnu.boot.mapper;


import com.sicnu.boot.pojo.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author 汪杨
 * @version 1.0
 * description:
 * @date 2022/11/17 9:49
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MessageMapperTest {
    @Resource
    private MessageMapper messageMapper;

    @Test
    public void testGetById(){
        List<Message> messages = messageMapper.getMessageById(2);
        System.out.println(messages);
    }


}
