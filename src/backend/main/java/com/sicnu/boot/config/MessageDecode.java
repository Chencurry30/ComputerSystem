package com.sicnu.boot.config;

import com.google.gson.GsonBuilder;
import com.sicnu.boot.pojo.UserMessage;
import org.springframework.stereotype.Component;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * description:  消息实体的解码器
 *
 * @author :  胡建华
 * Data:    2022/12/03 15:36
 */
@Component
public class MessageDecode implements Decoder.Text<UserMessage> {

    @Override
    public UserMessage decode(String s) {
        // 利用 gson 处理消息实体，并格式化日期格式
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create()
                .fromJson(s, UserMessage.class);
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {}

    @Override
    public void destroy() {}

}
