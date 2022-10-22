package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/20 10:12
 */
@Mapper
public interface MajorMapper {
    /**
     * 查询专业
     * @param majorId：专业编号
     * @return Major
     */
    Major getMajorById(Integer majorId);

    /**
     * 查询专业
     * @param name：专业名字
     * @return Major
     */
    Major getMajorByName(String name);

    /**
     * 查询所有专业
     * @return List
     */
    List<Major> getAllMajor();
}
