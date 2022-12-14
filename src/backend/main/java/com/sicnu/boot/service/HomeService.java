package com.sicnu.boot.service;

import com.sicnu.boot.utils.ServerResponse;

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
}
