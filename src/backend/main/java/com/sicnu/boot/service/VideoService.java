package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.utils.ServerResponse;

import java.util.List;

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
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/15 20:26
     */
    ServerResponse<List<Video>> getVideoListBySelective();
}
