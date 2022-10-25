package com.sicnu.boot.service;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.VideoSelective;

import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/15 20:15
 */
public interface VideoService {

    /**
     * description: 通过选择，返回视频列表
     *
     * @param  videoSelective :
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/15 20:26
     */
    ServerResponse<PageInfo<Video>> getVideoListBySelective(VideoSelective videoSelective);

    /**
     * description: 获取视频分类筛选框
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/25 18:04
     */
    ServerResponse<List<Map<String,Object>>> getFilterBox();

    /**
     * description: 通过id获取视频详细信息
     *
     * @param videoId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/16 16:32
     */
    ServerResponse<Video> getVideoByVideoId(Integer videoId);
}
