package com.sicnu.boot.service.impl;


import com.github.pagehelper.PageHelper;
import com.sicnu.boot.mapper.CollegeMapper;
import com.sicnu.boot.pojo.College;
import com.sicnu.boot.service.CollegeService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
        return ServerResponse.createBySuccess("查询成功",college);
    }

    @Override
    public ServerResponse<College> addCollege(College college) {
        collegeMapper.addCollege(college);
        return ServerResponse.createBySuccess("添加成功",college);
    }

    @Override
    public ServerResponse<Integer> deleteCollege(Integer id) {
        collegeMapper.deleteCollege(id);
        return ServerResponse.createBySuccess("删除成功",id);
    }

    @Override
    public ServerResponse<List<College>> getAllCollege() {
        List<College> allCollege = collegeMapper.getAllCollege();
        return ServerResponse.createBySuccess("查询成功",allCollege);
    }

    @Override
    public ServerResponse<College> updateCollege(College college) {
        collegeMapper.updateCollegeById(college);
        return ServerResponse.createBySuccess("修改成功",college);
    }

    @Override
    public ServerResponse<List<College>> getCollegeByName(String name) {
        List<College> college = collegeMapper.getCollegeByName(name);
        return ServerResponse.createBySuccess("查询成功",college);
    }

    @Override
    public ServerResponse<List<College>> getCollegePage(Integer pageNum) {
        PageHelper.startPage(pageNum,4);
        List<College> college = collegeMapper.getAllCollege();
        return ServerResponse.createBySuccess("查询成功",college);
    }
}
