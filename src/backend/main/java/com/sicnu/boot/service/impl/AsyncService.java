package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.CollegeMapper;
import com.sicnu.boot.mapper.QuestionMapper;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.mapper.VideoMapper;
import com.sicnu.boot.pojo.College;
import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.pojo.QuestionChoice;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.vo.LoginUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * description:  异步service
 *
 * @author :  胡建华
 * Data:    2022/12/13 19:30
 */
@Service
public class AsyncService {

    @Resource
    private VideoMapper videoMapper;
    @Resource
    private QuestionMapper questionMapper;
    @Resource
    private CollegeMapper collegeMapper;
    @Resource
    private UserMapper userMapper;

    @Async("myExecutor")
    public CompletableFuture<List<Video>> searchVideo(String name){
        List<Video> list = videoMapper.getVideoByName(name);
        list = list.stream().peek(video -> {
            String nickname = userMapper.getNicknameByUserId(video.getAuthorId());
            if (StringUtils.isBlank(nickname)) {
                nickname = "";
            }
            video.setNickname(nickname);
        }).collect(Collectors.toList());
        return CompletableFuture.completedFuture(list);
    }

    @Async("myExecutor")
    public CompletableFuture<List<Question>> searchQuestion(String name){
        List<Question> list = questionMapper.getQuestionByName(name);
        for (Question question : list) {
            if (question.getQuestionType() <= 2){
                List<QuestionChoice> choiceList = questionMapper.getQuestionChoiceByQuestionId(question.getQuestionId());
                question.setQuestionChoiceList(choiceList);
            }
        }
        return CompletableFuture.completedFuture(list);
    }

    @Async("myExecutor")
    public CompletableFuture<List<College>> searchCollege(String name){
        List<College> list = collegeMapper.getCollegeByName(name);
        return CompletableFuture.completedFuture(list);
    }
}
