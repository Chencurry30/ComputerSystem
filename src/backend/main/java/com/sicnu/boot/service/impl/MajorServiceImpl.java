package com.sicnu.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.sicnu.boot.mapper.MajorMapper;
import com.sicnu.boot.pojo.Major;
import com.sicnu.boot.service.MajorService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.MajorClassify;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/20 11:14
 */
@Service
public class MajorServiceImpl implements MajorService {
    @Resource
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

    @Override
    public ServerResponse<List<Major>> getMajorListByCollegeId(Integer collegeId) {
        List<Major> major = majorMapper.getMajorListByCollegeId(collegeId);
        return ServerResponse.createBySuccess("查询成功",major);
    }

    @Override
    public ServerResponse<List<Map<String, Object>>> getFilterBox() {
        List<Map<String,Object>> list = new ArrayList<>();
        List<MajorClassify> majorClassify = majorMapper.getMajorClassify();
        majorClassify.sort(Comparator.comparingInt(MajorClassify::getClassifyId));
        Map<String,Object> classifyMap = new HashMap<>(5);
        classifyMap.put("list",majorClassify);
        classifyMap.put("id",5590773);
        classifyMap.put("name","分类");
        list.add(classifyMap);
        return ServerResponse.createBySuccess("获取成功",list);
    }

    @Override
    public ServerResponse<List<Major>> getMajorListBySelective(Integer collegeId,Integer classifyId) {
        List<Major> major = majorMapper.getMajorListBySelective(collegeId,classifyId);
        return ServerResponse.createBySuccess("成功",major);
    }
}
