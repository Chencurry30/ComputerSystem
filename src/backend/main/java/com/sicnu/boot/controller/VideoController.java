package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.service.VideoService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.VideoSelective;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/15 20:14
 */
@RestController
@RequestMapping("/videos")
public class VideoController {
    @Resource
    private VideoService videoService;

    @PostMapping("/pages")
    ServerResponse<List<Video>> getVideoListBySelective(@RequestBody VideoSelective videoSelective){
        return videoService.getVideoListBySelective(videoSelective);
    }

}
