package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.LogMapper;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.mapper.VideoMapper;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.utils.RedisUtils;
import com.sicnu.boot.vo.VideoType;
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
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private UserMapper userMapper;

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
     * description: 刷新视频的热点数据,每小时执行一次
     *
     * @author 胡建华
     * Date:  2022/12/15 19:17
     */
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void flushHotSpot(){
        List<VideoType> videoType = videoMapper.getVideoType();
        for (VideoType type : videoType) {
            List<Video> list = videoMapper.getVideoListByVideoType(type.getTypeId());
            //对list进行排序，然后取前4个
            list = list.stream().sorted((o1, o2) ->
                            5 * (o2.getViewNum() - o1.getViewNum()) +
                            3 * (o2.getCollectionNum() -o1.getCollectionNum())
                            + 2 * (o2.getCommentNum() - o1.getCommentNum())).limit(4).peek(video ->
                            video.setNickname(userMapper.getNicknameByUserId(video.getAuthorId()))).
                    collect(Collectors.toList());
            //存到redis中
            redisUtils.setCacheList(HomeServiceImpl.HOT_SPOT + type.getTypeId(),list);
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
