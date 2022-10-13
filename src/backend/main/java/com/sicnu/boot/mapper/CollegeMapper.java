package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.College;
import com.sicnu.boot.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 蔡名展
 * @version 1.0
 * description :
 * @date 2022/10/13 14:39
 */
@Mapper
public interface CollegeMapper {
    /**
     * 添加院校
     * @param college:学校
     */
    void addCollege(College college);

    /**
     * 查询院校
     * @param collegeId:学校id
     * @return College
     */
    College getCollegeById(Integer collegeId);
}
