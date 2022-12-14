package com.sicnu.boot.service;

import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.StsTokenVo;

import java.util.Map;

/**
 * description:
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

    /**
     * description: 获取视频图片
     *
     * @param fileName:
     * @return ServerResponse<Map<String,String>>
     * @author 胡建华
     * Date:  2022/11/29 14:54
     */
    ServerResponse<Map<String, String>> getVideoPolicy(String fileName);

    /**
     * description: 上传动态图片
     *
     * @param fileName:
     * @return ServerResponse<Map<String,String>>
     * @author 胡建华
     * Date:  2022/11/29 15:06
     */
    ServerResponse<Map<String, String>> getDynamicPolicy(String fileName);

    /**
     * description: 获取sts认证
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/29 16:36
     */
    ServerResponse<StsTokenVo> getStsToken();
}
