package com.sicnu.boot.service.impl;


import com.sicnu.boot.mapper.MessageMapper;
import com.sicnu.boot.pojo.Message;
import com.sicnu.boot.service.MessageService;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * description:
 *
 * @author :  汪杨
 * Data:    2022/11/15 21:38
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;

    @Override
    public ServerResponse<String> insertMessage(Message message) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        message.setUserId(loginUser.getUser().getUserId());
        //设置评论时间
        message.setMessageTime(LocalDateTime.now());
        messageMapper.insertMessage(message);
        return ServerResponse.createBySuccessMessage("插入成功");
    }

    @Override
    public ServerResponse<List<Message>> getAllMessage() {
        List<Message> allMessage = messageMapper.getAllMessage();
        if (allMessage.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("查询成功",allMessage);
    }

    @Override
    public ServerResponse<List<Message>> getMessageById(Integer id) {
        List<Message> messages=messageMapper.getMessageById(id);
        return ServerResponse.createBySuccess("查询成功",messages);
    }
}
