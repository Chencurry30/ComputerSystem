package com.sicnu.boot.service;

import com.sicnu.boot.vo.VideoSelective;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/25 21:50
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class VideoServiceTest {
    @Resource
    private VideoService videoService;
    @Test
    public void testGetFilterBox(){
        System.out.println(videoService.getFilterBox());
    }
    @Test
    public void testGetVideoListBySelective(){
        VideoSelective videoSelective = new VideoSelective("null",0,0,0,1);
        System.out.println(videoService.getVideoListBySelective(videoSelective));
    }
}
