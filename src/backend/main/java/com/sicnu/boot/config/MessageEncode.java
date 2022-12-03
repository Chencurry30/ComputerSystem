package com.sicnu.boot.config;

import com.google.gson.GsonBuilder;
import com.sicnu.boot.pojo.UserMessage;
import org.springframework.stereotype.Component;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * description:  消息实体的编码器
 *
 * @author :  胡建华
 * Data:    2022/12/03 15:38
 */
@Component
public class MessageEncode implements Encoder.Text<UserMessage> {

    @Override
    public String encode(UserMessage messageEntity) {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create()
                .toJson(messageEntity);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {}

    @Override
    public void destroy() {}

}
