package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Major;
import com.sicnu.boot.utils.ServerResponse;

import java.util.List;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/20 11:14
 */
public interface MajorService {
    /**
     * 查询专业
     * @param id：专业id
     * @return Major
     */
    ServerResponse<Major> getMajorById(Integer id);

    /**
     * 查询专业
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
}
