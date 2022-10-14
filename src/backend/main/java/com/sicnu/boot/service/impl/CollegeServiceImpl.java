package com.sicnu.boot.service.impl;


import com.sicnu.boot.mapper.CollegeMapper;
import com.sicnu.boot.pojo.College;
import com.sicnu.boot.service.CollegeService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/14 13:49
 */

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;


    @Override
    public ServerResponse<College> getCollegeById(Integer id) {
        College college=collegeMapper.getCollegeById(id);
        return ServerResponse.createBySuccess("返回成功",college);
    }


}
