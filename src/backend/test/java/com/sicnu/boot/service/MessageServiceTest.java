package com.sicnu.boot.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * description:
 *
 * @author 汪杨
 * @version 1.0
 * @date 2022/11/17
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MessageServiceTest {
    @Resource
    private MessageService messageService;

    @Test
    public void testGetMessageById(){
        System.out.println(messageService.getMessageById(2));
    }
}
