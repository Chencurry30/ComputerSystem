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
     * description: 针对用户头像，后端签名加密
     *
     * @param fileName:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/19 14:49
     */
    ServerResponse<Map<String, String>> getUserPolicy(String fileName);

    /**
     * description: 针对题库，后端签名加密
     *
     * @param fileName:
     * @param dir:
     * @return ServerResponse<Map<String,String>>
     * @author 胡建华
     * Date:  2022/11/24 15:43
     */
    ServerResponse<Map<String, String>> getQuestionPolicy(String fileName, String dir);
}
