package com.sicnu.boot.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/20 9:38
 */
@Mapper
public interface HomeMapper {
    /**
     * description: 获取视频数
     *
     * @return int
     * @author 胡建华
     * Date:  2022/12/20 9:40
     */
    int getVideoCount();

    /**
     * description: 获取老师数
     *
     * @return int
     * @author 胡建华
     * Date:  2022/12/20 9:40
     */
    int getTeacherCount();

    /**
     * description: 获取题目数
     *
     * @return int
     * @author 胡建华
     * Date:  2022/12/20 9:40
     */
    int getQuestionCount();

    /**
     * description: 获取用户数
     *
     * @return int
     * @author 胡建华
     * Date:  2022/12/20 9:40
     */
    int getUserCount();

    /**
     * description: 获取院校数
     *
     * @return int
     * @author 胡建华
     * Date:  2022/12/20 9:40
     */
    int getSchoolCount();
}
