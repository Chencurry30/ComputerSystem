package com.sicnu.boot.controller;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.service.VideoService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.VideoSelective;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/pages/{typeId}-{durationId}-{sortId}-{pageNum}")
    ServerResponse<PageInfo<Video>> getVideoListBySelective(
            String videoName, @PathVariable Integer typeId,
            @PathVariable Integer durationId,@PathVariable Integer sortId,@PathVariable Integer pageNum){

        return videoService.getVideoListBySelective(new VideoSelective(videoName,typeId,durationId,sortId,pageNum));
    }

    /**
     * description: 获取视频筛选框
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/25 18:03
     */
    @GetMapping("/filterBox")
    ServerResponse<List<Map<String,Object>>> getFilterBox(){
        return videoService.getFilterBox();
    }

    @GetMapping("/{videoId}")
    ServerResponse<Video> getVideoByVideoId(@Min (value = 1,message = "视频id最小值为1")
                                            @PathVariable("videoId")Integer videoId){
        return videoService.getVideoByVideoId(videoId);
    }

}
