package com.sicnu.boot.service;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.pojo.VideoExamine;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.ExamineVideo;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/30 16:13
 */
public interface VideoManageService {
    /**
     * description: 获取视频列表
     *
     * @param pageNum :
     * @param typeId :
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/30 16:20
     */
    ServerResponse<PageInfo<Video>> getVideoList(Integer pageNum, Integer typeId);

    /**
     * description: 删除指定视频
     *
     * @param videoId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/30 16:33
     */
    ServerResponse<String> deleteVideoById(Integer videoId);

    /**
     * description: 获取审核列表
     *
     * @param pageNum :
     * @param examineStatus :
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/30 17:03
     */
    ServerResponse<PageInfo<VideoExamine>> getVideoExamineList(Integer pageNum, Integer examineStatus);

    /**
     * description: 审核视频
     *
     * @param examineVideo:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/30 17:21
     */
    ServerResponse<String> examineVideo(ExamineVideo examineVideo);
}
