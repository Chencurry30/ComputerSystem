package com.sicnu.boot.aop;

import com.sicnu.boot.pojo.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * description:  事件发布者
 *
 * @author :  胡建华
 * Data:    2022/12/26 22:43
 */
@Component
public class EventPubListener {
    @Resource
    private ApplicationContext applicationContext;

    /**
     * description: 事件发布方法
     *
     * @param log:
     * @author 胡建华
     * Date:  2022/12/26 22:45
     */
    public void pushListener(Log log) {
        applicationContext.publishEvent(log);
    }
}
