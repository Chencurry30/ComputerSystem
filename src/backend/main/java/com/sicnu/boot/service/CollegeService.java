package com.sicnu.boot.service;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.College;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.CollegeSelective;

import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/14 13:25
 */
public interface CollegeService {

    /**
     * 查询学校
     *
     * @param id：学校id
     * @return College
     */
    ServerResponse<College> getCollegeById(Integer id);

    /**
     * 查询所有学校
     *
     * @return List
     */
    ServerResponse<List<College>> getAllCollege();

    /**
     * 查询学校
     *
     * @param name：学校名
     * @return College
     */
    ServerResponse<List<College>> getCollegeByName(String name);

    /**
     * 分页获取学校
     * @param pageNum：页数
     * @return List
     */
    ServerResponse<List<College>> getCollegePage(Integer pageNum);

    /**
     * 获取学校分类筛选框
     *
     * @return ServerResponse
     */
    ServerResponse<List<Map<String, Object>>> getFilterBox();

    /**
     * 通过选择，返回学校列表
     *
     * @param collegeSelective：列表信息
     * @return ServerResponse
     */
    ServerResponse<PageInfo<College>> getCollegeListBySelective(CollegeSelective collegeSelective);
}