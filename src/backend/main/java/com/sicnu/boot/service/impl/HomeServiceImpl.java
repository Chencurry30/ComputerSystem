package com.sicnu.boot.service.impl;

import com.sicnu.boot.pojo.College;
import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.service.HomeService;
import com.sicnu.boot.utils.ServerResponse;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

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
        if (!Objects.isNull(searchCollege)){
            collegeList = searchCollege.get();
            map.put("collegeList",collegeList);
        }
        if (!Objects.isNull(searchQuestion)){
            questionList = searchQuestion.get();
            map.put("questionList",questionList);
        }
        if (!Objects.isNull(searchVideo)){
            videoList = searchVideo.get();
            map.put("videoList",videoList);
        }
        return ServerResponse.createBySuccess("获取成功",map);
    }
}
