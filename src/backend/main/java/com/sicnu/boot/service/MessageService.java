package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Message;
import com.sicnu.boot.utils.ServerResponse;

import java.util.List;

/**
 * description:评论功能
 *
 * @author :  汪杨
 * Data:    2022/11/16 21:38
 */
public interface MessageService {
    /**
     * description: 插入一条评论
     *
     * @param message:
     * @return ServerResponse
     * @author 汪杨
     * Date:  2022/11/15 10:11
     */
    ServerResponse<String> insertMessage(Message message);

    /**
     * description: 显示评论
     *
     * @return ServerResponse
     * @author 汪杨
     * Date:  2022/11/15 10:11
     */
    ServerResponse<List<Message>> getAllMessage();


    /**
     * description: 前端的老师id
     * @param id:老师id
     * @return ServerResponse
     * @author 汪杨
     * Date:  2022/11/16 10:11
     */
    ServerResponse<List<Message>> getMessageById(Integer id);
}
