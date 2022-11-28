package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Dynamic;
import com.sicnu.boot.utils.ServerResponse;

import java.util.List;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/11/26 14:19
 */
public interface DynamicService {
    /**
     * description: 添加一条动态
     *
     * @param dynamic:
     * @return com.sicnu.boot.utils.ServerResponse<java.lang.String>
     * @author 蔡名展
     * Date 2022/11/26 14:27
     */
    ServerResponse<String> addDynamic(Dynamic dynamic);

    /**
     * description: 删除一条动态
     *
     * @param dynamicId:
     * @return com.sicnu.boot.utils.ServerResponse<java.lang.String>
     * @author 蔡名展
     * Date 2022/11/26 14:52
     */
    ServerResponse<String> deleteDynamic(Integer dynamicId);

    /**
     * description: 查找用户所有动态
     *
     * @param userId:
     * @return com.sicnu.boot.utils.ServerResponse<java.util.List<com.sicnu.boot.pojo.Dynamic>>
     * @author 蔡名展
     * Date 2022/11/26 16:00
     */
    ServerResponse<List<Dynamic>> getDynamicByUserId(Integer userId);

    /**
     * description:
     *
     * @return com.sicnu.boot.utils.ServerResponse<java.util.List<com.sicnu.boot.pojo.Dynamic>>
     * @author 蔡名展
     * Date 2022/11/28 14:19
     */
    ServerResponse<List<Dynamic>> getAllDynamic();
}
