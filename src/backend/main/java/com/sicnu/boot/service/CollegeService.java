package com.sicnu.boot.service;

import com.sicnu.boot.pojo.College;
import com.sicnu.boot.utils.ServerResponse;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/14 13:25
 */
public interface CollegeService{

    /**
     * 查询学校
     * @param id：学校id
     * @return College
     */
    ServerResponse<College> getCollegeById(Integer id);

}
