package com.sicnu.boot.service;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Dynamic;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.DynamicVo;

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
     * @param dynamic 动态
     * @return com.sicnu.boot.utils.ServerResponse<java.lang.String>
     * @author 蔡名展
     * Date 2022/11/26 14:27
     */
    ServerResponse<String> addDynamic(Dynamic dynamic);

    /**
     * description: 删除一条动态
     *
     * @param dynamicId 动态id
     * @return com.sicnu.boot.utils.ServerResponse<java.lang.String>
     * @author 蔡名展
     * Date 2022/11/26 14:52
     */
    ServerResponse<String> deleteDynamic(Integer dynamicId);

    /**
     * description: 查找用户所有动态
     *
     * @param userId 用户id
     * @param pageNum 页数
     * @return com.sicnu.boot.utils.ServerResponse<com.github.pagehelper.PageInfo<com.sicnu.boot.vo.DynamicVo>>
     * @author 蔡名展
     * Date 2022/11/30 21:24
     */
    ServerResponse<PageInfo<DynamicVo>> getDynamicByUserId(Integer userId,Integer pageNum);

    /**
     * description: 查找所有动态
     *
     * @param pageNum 页数
     * @return com.sicnu.boot.utils.ServerResponse<com.github.pagehelper.PageInfo<com.sicnu.boot.vo.DynamicVo>>
     * @author 蔡名展
     * Date 2022/11/30 20:05
     */
    ServerResponse<PageInfo<DynamicVo>> getAllDynamic(Integer pageNum);
}
