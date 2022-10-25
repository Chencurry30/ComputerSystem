package com.sicnu.boot.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.mapper.CollegeMapper;
import com.sicnu.boot.pojo.College;
import com.sicnu.boot.service.CollegeService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.CollegeAttribute;
import com.sicnu.boot.vo.CollegeRegion;
import com.sicnu.boot.vo.CollegeSelective;
import com.sicnu.boot.vo.CollegeType;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/14 13:49
 */

@Service
public class CollegeServiceImpl implements CollegeService {

    @Resource
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
        PageHelper.startPage(pageNum,6);
        List<College> college = collegeMapper.getAllCollege();
        return ServerResponse.createBySuccess("查询成功",college);
    }

    @Override
    public ServerResponse<List<Map<String, Object>>> getFilterBox() {
        List<Map<String,Object>> list = new ArrayList<>();
        //添加地区筛选
        List<CollegeRegion> collegeRegion = collegeMapper.getCollegeRegion();
        collegeRegion.add(new CollegeRegion(0,"全部"));
        collegeRegion.sort(Comparator.comparingInt(CollegeRegion::getRegionId));
        Map<String,Object> RegionMap = new HashMap<>(5);
        RegionMap.put("list",collegeRegion);
        RegionMap.put("id",123456);
        RegionMap.put("name","地区");
        list.add(RegionMap);
        //添加类型筛选
        List<CollegeType> collegeType = collegeMapper.getCollegeType();
        collegeType.add(new CollegeType(0,"全部"));
        collegeType.sort(Comparator.comparingInt(CollegeType::getTypeId));
        Map<String,Object> TypeMap = new HashMap<>(5);
        TypeMap.put("list",collegeType);
        TypeMap.put("id",123456);
        TypeMap.put("name","类型");
        list.add(TypeMap);
        //添加属性筛选
        List<CollegeAttribute> collegeAttribute = collegeMapper.getCollegeAttribute();
        collegeAttribute.add(new CollegeAttribute(0,"全部"));
        collegeAttribute.sort(Comparator.comparingInt(CollegeAttribute::getAttributeId));
        Map<String,Object> AttributeMap = new HashMap<>(5);
        AttributeMap.put("list",collegeAttribute);
        AttributeMap.put("id",123456);
        AttributeMap.put("name","地区");
        list.add(AttributeMap);
        return ServerResponse.createBySuccess("获取成功",list);
    }

    @Override
    public ServerResponse<PageInfo<College>> getCollegeListBySelective(CollegeSelective collegeSelective) {
        //获取分页信息
        PageHelper.startPage(collegeSelective.getPageNum(),6);
        List<College> list = collegeMapper.getCollegeListBySelective(collegeSelective);
        PageInfo<College> pageInfo = new PageInfo<>(list);
        return ServerResponse.createBySuccess("成功",pageInfo);
    }
}
