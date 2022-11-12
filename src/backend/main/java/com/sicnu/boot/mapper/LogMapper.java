package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/11 20:10
 */
@Mapper
public interface LogMapper {
    /**
     * description: 插入一条日志
     *
     * @param log:
     * @author 胡建华
     * Date:  2022/11/11 20:56
     */
    void insertLog(Log log);

    /**
     * description: 获取日志列表
     *
     * @return List<Log>
     * @author 胡建华
     * Date:  2022/11/12 15:08
     */
    List<Log> getLogList();

    /**
     * description: 通过logId删除日志
     *
     * @param logId:
     * @author 胡建华
     * Date:  2022/11/12 15:10
     */
    void deleteLogByLogId(Integer logId);

    /**
     * description: 批量删除日志
     *
     * @param logIds:
     * @author 胡建华
     * Date:  2022/11/12 15:13
     */
    void deleteLogByLogIds(List<Integer> logIds);
}
