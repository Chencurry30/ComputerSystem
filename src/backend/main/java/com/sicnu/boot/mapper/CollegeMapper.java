package com.sicnu.boot.mapper;


import com.sicnu.boot.pojo.College;
import com.sicnu.boot.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 蔡名展
 * @version 1.0
 * description :
 * @date 2022/10/13 14:39
 */
@Mapper
public interface CollegeMapper {

    /**
     * 通过id查询学校
     * @param collegeId：学校id
     * @return College
     */
    College getCollegeById(Integer collegeId);

    /**
     * 通过名字查询学校
     * @param name：学校名
     * @return College
     */
    List<College> getCollegeByName(String name);

    /**
     * 查询所有学校
     * @return College
     */
    List<College> getAllCollege();

    /**
     * 获取学校地区
     * @return List
     */
    List<CollegeRegion> getCollegeRegion();

    /**
     * 获取学校类型
     * @return List
     */
    List<CollegeType> getCollegeType();

    /**
     * 获取学校属性
     * @return List
     */
    List<CollegeAttribute> getCollegeAttribute();

    /**
     * 通过选择，返回学校列表
     * @param collegeSelective：列表信息
     * @return List
     */
    List<College> getCollegeListBySelective(CollegeSelective collegeSelective);

}
