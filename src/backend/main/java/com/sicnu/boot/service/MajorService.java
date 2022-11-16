package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Major;
import com.sicnu.boot.utils.ServerResponse;

import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/20 11:14
 */
public interface MajorService {
    /**
     * 通过专业id查询专业
     * @param id：专业id
     * @return Major
     */
    ServerResponse<Major> getMajorById(Integer id);

    /**
     * 通过专业名查询专业
     * @param name：专业名
     * @return Major
     */
    ServerResponse<Major> getMajorByName(String name);

    /**
     * 查询所有专业
     * @return List
     */
    ServerResponse<List<Major>> getAllMajor();

    /**
     * 分页查询专业
     * @param pageNum：页码数
     * @return Page
     */
    ServerResponse<List<Major>> getMajorPage(Integer pageNum);

    /**
     * 根据学校id查询相应专业列表
     * @param collegeId：院校id
     * @return List
     */
    ServerResponse<List<Major>> getMajorListByCollegeId(Integer collegeId);

    /**
     * 获取专业分类筛选框
     * @return List
     */
    ServerResponse<List<Map<String, Object>>> getFilterBox();

    /**
     * 通过选择获取专业
     * @param collegeId：学校id
     * @param classifyId：分类id
     * @return List
     */
    ServerResponse<List<Major>> getMajorListBySelective(Integer collegeId,Integer classifyId);
}
