package com.sicnu.boot.service;

import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.mapper.VideoMapper;
import com.sicnu.boot.pojo.Video;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/16 10:06
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class HomeServiceTest {

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private UserMapper userMapper;

    @Test
    public void testHotSpot(){
        List<Video> list = videoMapper.getVideoListByVideoType(1);
//        list.forEach(System.out :: println);
        //对list进行排序，然后取前4个
        //依据 浏览数:收藏数:评论数 = 5:3:2 来排序
        list = list.stream().sorted((o1, o2) ->
                5 * (o2.getViewNum() - o1.getViewNum()) + 3 * (o2.getCollectionNum() -o1.getCollectionNum())
                + 2 * (o2.getCommentNum() - o1.getCommentNum())).limit(4).peek(video ->
                        video.setNickname(userMapper.getNicknameByUserId(video.getAuthorId()))).
                collect(Collectors.toList());
        list.forEach(System.out :: println);
    }

}
