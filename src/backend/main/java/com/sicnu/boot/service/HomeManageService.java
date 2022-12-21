package com.sicnu.boot.service;

import com.sicnu.boot.utils.ServerResponse;

import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/20 9:33
 */
public interface HomeManageService {
    /**
     * description: 获取首页数据
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/20 9:53
     */
    ServerResponse<Map<String,Map<String,Integer>>> getHomeCounts();
}
