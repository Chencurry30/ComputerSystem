package com.sicnu.boot.controller;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.pojo.VideoExamine;
import com.sicnu.boot.service.VideoService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.VideoSelective;
import org.hibernate.validator.constraints.Length;
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
            @Length(max = 20,message = "视频名字的最大值为20") String videoName,
            @Min(value = 0,message = "typeId的最小值为0") @PathVariable Integer typeId,
            @Min(value = 0,message = "durationId的最小值为0") @PathVariable Integer durationId,
            @Min(value = 0,message = "sortId的最小值为0") @PathVariable Integer sortId,
            @Min(value = 1,message = "pageNum的最小值为1") @PathVariable Integer pageNum){
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

    /**
     * description: 收藏视频，或取消收藏视频
     *
     * @param videoId:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/23 18:56
     */
    @PostMapping("/collect/{videoId}")
    ServerResponse<String> collectVideo(@Min (value = 1,message = "视频id最小值为1")
                                @PathVariable("videoId")Integer videoId){
        return videoService.collectVideo(videoId);
    }

    /**
     * description: 获取用户的收藏列表
     *
     * @param pageNum:
     * @return ServerResponse<PageInfo<Video>>
     * @author 胡建华
     * Date:  2022/11/23 19:39
     */
    @GetMapping("/collect/{pageNum}-{userId}")
    ServerResponse<PageInfo<Video>> getCollectVideoList(@Min(value = 1,message = "pageNum的最小值为1")
                                       @PathVariable Integer pageNum,@Min(value = 1,message = "pageNum的最小值为1")
                                        @PathVariable Integer userId){
        return videoService.getCollectVideoList(pageNum,userId);
    }

    /**
     * description: 上传视频
     *
     * @param videoExamine:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/30 18:34
     */
    @PostMapping
    ServerResponse<String> uploadVideo(@Validated @RequestBody VideoExamine videoExamine){
        return videoService.uploadVideo(videoExamine);
    }

}
