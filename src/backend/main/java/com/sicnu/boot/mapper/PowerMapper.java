package com.sicnu.boot.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:  TODO
 *
 * @author :  胡建华
 * Data:    2022/10/12 16:29
 */
@Mapper
public interface PowerMapper {
    /**
     * description: 通过userid获取用户权限
     *
     * @param id:
     * @return List<String>
     * @author 胡建华
     * Date:  2022/10/12 16:30
     */
    List<String> selectPermsByUserId(Integer id);
}
