package com.sicnu.boot.mapper;


import com.sicnu.boot.pojo.College;
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

}
