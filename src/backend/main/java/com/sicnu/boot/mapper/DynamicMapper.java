package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Dynamic;
import com.sicnu.boot.vo.DynamicVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/11/26 13:19
 */
@Mapper
public interface DynamicMapper {
    /**
     * description: 添加一条动态
     *
     * @param dynamic:
     * @author 蔡名展
     * Date 2022/11/26 13:52
     */
    void addDynamic(Dynamic dynamic);

    /**
     * description: 删除一条动态
     *
     * @param dynamicId:
     * @param userId:
     * @author 蔡名展
     * Date 2022/11/26 14:11
     */
    void deleteDynamic(Integer dynamicId,Integer userId);

    /**
     * description: 通过用户id查询动态
     *
     * @param userId:
     * @return java.util.List<com.sicnu.boot.pojo.Dynamic>
     * @author 蔡名展
     * Date 2022/11/26 15:57
     */
    List<DynamicVo> getDynamicByUserId(Integer userId);

    /**
     * description: 查询所有动态
     *
     * @return java.util.List<com.sicnu.boot.pojo.Dynamic>
     * @author 蔡名展
     * Date 2022/11/28 14:16
     */
    List<DynamicVo> getAllDynamic();
}
