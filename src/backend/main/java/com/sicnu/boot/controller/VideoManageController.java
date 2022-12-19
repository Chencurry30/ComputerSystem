package com.sicnu.boot.controller;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.pojo.VideoExamine;
import com.sicnu.boot.service.VideoManageService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.ExamineVideo;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/30 16:13
 */
@RestController
@RequestMapping("/admin/videos")
@Validated
public class VideoManageController {
    @Resource
    private VideoManageService videoManageService;

    /**
     * description: 获取视频列表
     *
     * @param typeId:
     * @param pageNum:
     * @return ServerResponse<PageInfo<Video>>
     * @author 胡建华
     * Date:  2022/11/30 18:35
     */
    @GetMapping("/pages/{typeId}-{pageNum}")
    @PreAuthorize("hasAuthority('system:video:view')")
    ServerResponse<PageInfo<Video>> getVideoList(@Min(value = 0,message = "typeId的最小值为0") @PathVariable Integer typeId,
                  @Min(value = 1,message = "pageNum的最小值为1") @PathVariable Integer pageNum){
        return videoManageService.getVideoList(pageNum,typeId);
    }

    /**
     * description: 删除指定视频
     *
     * @param videoId:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/30 18:35
     */
    @DeleteMapping("/{videoId}")
    @PreAuthorize("hasAuthority('system:video:delete')")
    ServerResponse<String> deleteVideoById(@Min(value = 1,message = "videoId的最小值为1") @PathVariable Integer videoId){
        return videoManageService.deleteVideoById(videoId);
    }

    /**
     * description: 获取审核列表
     *
     * @param pageNum:
     * @param examineStatus:
     * @return ServerResponse<PageInfo<VideoExamine>>
     * @author 胡建华
     * Date:  2022/11/30 18:34
     */
    @GetMapping("/examine/{examineStatus}-{pageNum}")
    @PreAuthorize("hasAuthority('system:video:viewExamine')")
    ServerResponse<PageInfo<VideoExamine>> getVideoExamineList(@Min(value = 1,message = "pageNum的最小值为1") @PathVariable Integer pageNum,
                                                               @Range(min = -1,max = 2,message = "examineStatus的范围为-1到2") @PathVariable Integer examineStatus){
        return videoManageService.getVideoExamineList(pageNum,examineStatus);
    }

    /**
     * description: 审核视频
     *
     * @param examineVideo:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/30 18:34
     */
    @PutMapping("/examine")
    @PreAuthorize("hasAuthority('system:video:examine')")
    ServerResponse<String> examineVideo(@Validated @RequestBody ExamineVideo examineVideo){
        return videoManageService.examineVideo(examineVideo);
    }
}
