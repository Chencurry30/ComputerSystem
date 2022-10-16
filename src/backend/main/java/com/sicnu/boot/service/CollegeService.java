package com.sicnu.boot.service;

import com.sicnu.boot.pojo.College;
import com.sicnu.boot.utils.ServerResponse;

import java.util.List;

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

    /**
     * 添加学校
     * @param college：学校信息
     * @return College
     */
    ServerResponse<College> addCollege(College college);

    /**
     * 删除学校
     * @param id：学校id
     * @return College
     */
    ServerResponse<Integer> deleteCollege(Integer id);

    /**
     * 查询所有学校
     * @return List
     */
    ServerResponse<List<College>> getAllCollege();

    /**
     * 修改学校信息
     * @param college：学校信息
     * @return College
     */
    ServerResponse<College> updateCollege(College college);

    /**
     * 查询学校
     * @param name：学校名
     * @return College
     */
    ServerResponse<List<College>> getCollegeByName(String name);

    /**
     *
     * @param pageNum；页码数
     * @return Page
     */
    ServerResponse<List<College>> getCollegePage(Integer pageNum);
}
