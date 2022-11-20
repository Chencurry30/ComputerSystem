package com.sicnu.boot.service;

import com.sicnu.boot.utils.ServerResponse;

import java.util.Map;

/**
 * description:  TODO
 *
 * @author :  胡建华
 * Data:    2022/11/19 14:45
 */
public interface OssService {
    /**
     * description: 后端签名加密
     *
     * @param fileName:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/19 14:49
     */
    ServerResponse<Map<String, String>> policy(String fileName);
}
