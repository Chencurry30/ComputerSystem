package com.sicnu.boot.service.impl;

import com.sicnu.boot.service.HomeManageService;
import com.sicnu.boot.utils.RedisUtils;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/20 9:33
 */
@Service
public class HomeManageServiceImpl implements HomeManageService {

    @Resource
    private TimedTaskService timedTaskService;

    @Resource
    private RedisUtils redisUtils;

    @Override
    public ServerResponse<Map<String,Map<String,Integer>>> getHomeCounts() {
        //从redis中获取数据
        Map<String,Map<String,Integer>> cacheMap = redisUtils.getCacheMap(TimedTaskService.HOME_MAP);
        if (cacheMap.isEmpty()){
            //刷新
            timedTaskService.flushCounts();
            //重新获取
            cacheMap = redisUtils.getCacheMap(TimedTaskService.HOME_MAP);
        }
        return ServerResponse.createBySuccess("获取成功",cacheMap);
    }
}
