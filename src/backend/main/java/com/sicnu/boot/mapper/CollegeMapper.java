package com.sicnu.boot.mapper;


import com.sicnu.boot.pojo.College;
import com.sicnu.boot.service.CollegeService;
import com.sicnu.boot.vo.CollegeAttribute;
import com.sicnu.boot.vo.CollegeRegion;
import com.sicnu.boot.vo.CollegeSelective;
import com.sicnu.boot.vo.CollegeType;
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
     * 添加学校
     * @param college：学校
     */
    void addCollege(College college);

    /**
     * 查询学校
     * @param collegeId：学校id
     * @return College
     */
    College getCollegeById(Integer collegeId);

    /**
     * 查询学校
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
     * 删除学校
     * @param collegeId：学校id
     * @return Integer
     */
    Integer deleteCollege(Integer collegeId);

    /**
     * 更改学校信息
     * @param college：学校信息
     */
    void updateCollegeById(College college);

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
