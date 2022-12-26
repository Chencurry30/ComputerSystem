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
     * @param examineId:评论Id
     */
    void updateAgrExamine(Integer examineId);

    void updateDisAgrExamine(Integer examineId,String reviewComment);

    void deleteExamine(Integer useId);
    void passExamine(TeacherExamine examine);

    TeacherExamine getExamine(Integer examineId);
    TeacherExamine getUserId(Integer userId);
}
