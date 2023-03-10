package com.sicnu.boot.service.impl;

import com.sicnu.boot.pojo.College;
import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.service.HomeService;
import com.sicnu.boot.utils.RedisUtils;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/13 19:22
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    private AsyncService asyncService;

    @Resource
    private RedisUtils redisUtils;

    public static final String HOT_SPOT = "video_spot:";

    @Resource
    private TimedTaskService timedTaskService;

    @SneakyThrows
    @Override
    public ServerResponse<Map<String,Object>> search(String name) {
        CompletableFuture<List<College>> searchCollege = asyncService.searchCollege(name);
        CompletableFuture<List<Question>> searchQuestion = asyncService.searchQuestion(name);
        CompletableFuture<List<Video>> searchVideo = asyncService.searchVideo(name);
        //等待所有任务都执行完
        CompletableFuture.allOf(searchCollege,searchVideo,searchQuestion);
        // 获取每个任务的返回结果
        List<College> collegeList;
        List<Question> questionList;
        List<Video> videoList;
        Map<String,Object> map = new HashMap<>(5);
        AtomicReference<Integer> nums = new AtomicReference<>(1);
        if (!Objects.isNull(searchCollege)){
            collegeList = searchCollege.get();
            collegeList.forEach(item -> item.setId(nums.getAndSet(nums.get() + 1)));
            map.put("collegeList",collegeList);
        }
        if (!Objects.isNull(searchQuestion)){
            questionList = searchQuestion.get();
            questionList.forEach(item -> item.setId(nums.getAndSet(nums.get() + 1)));
            map.put("questionList",questionList);
        }
        if (!Objects.isNull(searchVideo)){
            videoList = searchVideo.get();
            videoList.forEach(item -> item.setId(nums.getAndSet(nums.get() + 1)));
            map.put("videoList",videoList);
        }
        if (map.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("获取成功",map);
    }

    @Override
    public ServerResponse<List<Video>> getVideoListByType(Integer typeId) {
        List<Video> cacheList = redisUtils.getCacheList(HOT_SPOT + typeId);
        if (Objects.isNull(cacheList) || cacheList.isEmpty()){
            //手动刷新热点数据
            timedTaskService.flushHotSpot();
            //重新获取
            cacheList = redisUtils.getCacheList(HOT_SPOT + typeId);
        }
        //没有数据
        if (cacheList.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode()
                    , "没有数据");
        }
        return ServerResponse.createBySuccess("获取成功",cacheList);
    }
}
