package com.sicnu.boot.service;

import com.sicnu.boot.pojo.TeacherExamine;
import com.sicnu.boot.utils.ServerResponse;
import java.util.List;

public interface TeacherExamineService {
    ServerResponse<List<TeacherExamine>> getAllExamine();

    /**
     * 新增申请
     * @param examine：申请
     * @return null
     */
    ServerResponse<String> insertExamine(TeacherExamine examine);

    /**
     * 修改审核状态
     * @param examineId:评论Id
     * @return null
     */
    ServerResponse<String> updateAgrExamine(Integer examineId);

    ServerResponse<String> updateDisAgrExamine(Integer examineId,String reviewComment);
}
