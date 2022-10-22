package com.sicnu.boot.controller;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.service.VideoService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.VideoSelective;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/15 20:14
 */
@RestController
@RequestMapping("/videos")
@Validated
public class VideoController {
    @Resource
    private VideoService videoService;

    @PostMapping("/pages")
    ServerResponse<PageInfo<Video>> getVideoListBySelective(@Validated @RequestBody VideoSelective videoSelective){
        return videoService.getVideoListBySelective(videoSelective);
    }

    @GetMapping("/{videoId}")
    ServerResponse<Video> getVideoByVideoId(@Min (value = 1,message = "视频id最小值为1")
                                            @PathVariable("videoId")Integer videoId){
        return videoService.getVideoByVideoId(videoId);
    }

}
