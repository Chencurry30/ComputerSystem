package com.sicnu.boot.service;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Log;
import com.sicnu.boot.utils.ServerResponse;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/12 15:25
 */
public interface LogService {
    /**
     * description: 获取日志列表
     *
     * @param pageNum:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/12 15:26
     */
    ServerResponse<PageInfo<Log>> getLogPage(Integer pageNum);

    /**
     * description: 通过id删除日志
     *
     * @param logId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/12 15:29
     */
    ServerResponse<String> deleteLogByLogId(Integer logId);

    /**
     * description:通过列表，批量删除日志
     *
     * @param logIds:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/12 15:27
     */
    ServerResponse<String> deleteLogByLogIds(List<Integer> logIds);
}
