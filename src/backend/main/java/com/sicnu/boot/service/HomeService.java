package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.utils.ServerResponse;

import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/13 19:21
 */
public interface HomeService {
    /**
     * description: 通过姓名进行模糊搜索
     *
     * @param name:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/13 19:24
     */
    ServerResponse<Map<String,Object>> search(String name);

    /**
     * description: 获取首页视频列表
     *
     * @param typeId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/15 11:32
     */
    ServerResponse<List<Video>> getVideoListByType(Integer typeId);
}
