package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.LogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * description:  定时任务
 *
 * @author :  胡建华
 * Data:    2022/12/13 10:47
 */
@Service
@Slf4j
@Component
public class TimedTaskService {

    @Resource
    private LogMapper logMapper;

    /**
     * description: 每晚11点执行删除数据库30天以前的日志的定时器
     *
     * @author 胡建华
     * Date:  2022/12/13 10:48
     */
    @Scheduled(cron = "0 0 23 * * ?")
    public void scheduled() {
        Date newDate= new Date();
        LocalDateTime deleteDate=getDate(newDate,30);
        try{
            logMapper.deleteByData(deleteDate);
        }catch (Exception e){
            log.error("删除30天前的日志数据失败！"+e.getMessage());
        }
    }

    /**
     * description: 获取今天之前多少天的日期
     *
     * @param now:
     * @param days:
     * @return LocalDateTime
     * @author 胡建华
     * Date:  2022/12/13 10:53
     */
    public static LocalDateTime getDate(Date now,int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -days);
        Date deleteDate=calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString=sdf.format(deleteDate);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateString,fmt);
    }
}
