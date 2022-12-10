package com.sicnu.boot.mapper;
import com.sicnu.boot.pojo.TeacherExamine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherExamineMapper {
    /**
     * 查询申请信息
     * @return Teacher
     */
    List<TeacherExamine> getAllExamine();

    /**
     * 新增申请
     */
    void insertExamine(TeacherExamine examine);

    /**
     * 管理员审核
     * @param userId:用户Id
     */
    void updateAgrExamine(Integer userId);

    void updateDisAgrExamine(Integer userId);
}
