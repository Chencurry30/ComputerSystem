package com.sicnu.boot.aop;

import com.sicnu.boot.mapper.LogMapper;
import com.sicnu.boot.pojo.Log;
import com.sicnu.boot.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * description:  事件监听者
 *
 * @author :  胡建华
 * Data:    2022/12/26 22:45
 */
@Slf4j
@Component
public class MyEventListener {

    @Resource
    private LogMapper logMapper;

    /**
     * description: 使用异步方法，开启监听
     *
     * @param sysLog:
     * @author 胡建华
     * Date:  2022/12/26 22:48
     */
    @Async
    @EventListener(Log.class)
    public void saveSysLog(Log sysLog) {
        log.info("=====即将异步保存到数据库======");
        logMapper.insertLog(sysLog);
    }

}
