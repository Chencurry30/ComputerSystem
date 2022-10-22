package com.sicnu.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.sicnu.boot.mapper.MajorMapper;
import com.sicnu.boot.pojo.Major;
import com.sicnu.boot.service.MajorService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/20 11:14
 */
@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;


    @Override
    public ServerResponse<Major> getMajorById(Integer id) {
        Major major = majorMapper.getMajorById(id);
        return ServerResponse.createBySuccess("查询成功",major);
    }

    @Override
    public ServerResponse<List<Major>> getAllMajor() {
        List<Major> major = majorMapper.getAllMajor();
        return ServerResponse.createBySuccess("查询成功",major);
    }

    @Override
    public ServerResponse<Major> getMajorByName(String name) {
        Major major = majorMapper.getMajorByName(name);
        return ServerResponse.createBySuccess("查询成功",major);
    }

    @Override
    public ServerResponse<List<Major>> getMajorPage(Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        List<Major> major = majorMapper.getAllMajor();
        return ServerResponse.createBySuccess("查询成功",major);
    }
}
