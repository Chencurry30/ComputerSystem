package com.sicnu.boot.config;

import com.google.gson.Gson;
import com.sicnu.boot.pojo.UserMessage;
import com.sicnu.boot.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * description:  websocket 服务器的配置
 * 配置 websocket 的路径
 *
 * @author :  胡建华
 * Data:    2022/12/03 15:43
 */
@Component
@ServerEndpoint(
        value = "/websocket/{id}",
        decoders = { MessageDecode.class },
        encoders = { MessageEncode.class },
        configurator = CustomSpringConfigurator.class
)
public class WebSocketServer {

    private Session session;
    private final Gson gson;
    private final RedisUtils redis;
    /**
     * description: 存储所有的用户连接
     */
    private static final Map<Integer, Session> WEBSOCKET_MAP = new ConcurrentHashMap<>();

    @Autowired
    public WebSocketServer(Gson gson, RedisUtils redis) {
        this.gson = gson;
        this.redis = redis;
    }

    @OnOpen
    public void onOpen(@PathParam("id") Integer id, Session session) {
        this.session = session;
        // 根据 /websocket/{id} 中传入的用户 id 作为键，存储每个用户的 session
        WEBSOCKET_MAP.put(id, session);
    }

    @OnMessage
    public void onMessage(UserMessage message) throws IOException {
        // 根据消息实体中的消息发送者和接受者的 id 组成信箱存储的键
        // 按两人id升序并以 - 字符分隔为键
        String key = IntStream.of(message.getFrom(), message.getTo())
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("-"));
        // 将信息存储到 redis 中
        redis.pushCacheList(key, message);
        // 如果用户在线就将信息发送给指定用户
        if (WEBSOCKET_MAP.get(message.getTo()) != null) {
            WEBSOCKET_MAP.get(message.getTo()).getBasicRemote().sendText(gson.toJson(message));
        }
    }

    @OnClose
    public void onClose() {
        // 用户退出时，从 map 中删除信息
        for (Map.Entry<Integer, Session> entry : WEBSOCKET_MAP.entrySet()) {
            if (this.session.getId().equals(entry.getValue().getId())) {
                WEBSOCKET_MAP.remove(entry.getKey());
                return;
            }
        }
    }

    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }

}
