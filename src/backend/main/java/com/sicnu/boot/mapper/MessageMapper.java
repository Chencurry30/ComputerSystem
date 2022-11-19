package com.sicnu.boot.mapper;


import com.sicnu.boot.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 汪杨
 * @version 1.0
 * description :
 * @date 2022/11/13 14:39
 */
@Mapper
public interface MessageMapper {


    /**
     * 插入评论
     * @param message：评论
     */
    void insertMessage(Message message);


    /**
     * 获得所有评论
     * @return null
     */
    List<Message> getAllMessage();

    /**
     * 根据老师id查找评论
     * @param teacherId :老师id
     * @return messages
     */
    List<Message> getMessageById(Integer teacherId);
}
