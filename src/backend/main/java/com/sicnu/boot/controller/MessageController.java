package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.Message;
import com.sicnu.boot.service.MessageService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author 汪杨
 * @version 1.0
 * @date 2022/11/15
 */
@RestController
@RequestMapping("/messages")
@Validated
public class MessageController {
    @Resource
    private MessageService messageService;
    /**
     * description: 插入一个评论
     *
     * @param message:
     * @return ServerResponse<String>
     * @author 汪杨
     * Date:  2022/11/15 10:47
     */
    @PostMapping
    ServerResponse<String> insertMessage(@Validated @RequestBody Message message){
        return messageService.insertMessage(message);
    }

    /**
     * 获得所有评论信息
     */
    @GetMapping("/AllMessages")
    public ServerResponse<List<Message>> getAllMessage(){
        return messageService.getAllMessage();
    }


    @GetMapping("/teacherId/{id}")
    public ServerResponse<List<Message>> getMessageById(@PathVariable("id") Integer id){
        return messageService.getMessageById(id);
    }

}
