package com.sicnu.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.aop.SysLogAnnotation;
import com.sicnu.boot.mapper.LogMapper;
import com.sicnu.boot.pojo.Log;
import com.sicnu.boot.service.LogService;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/12 15:25
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logMapper;

    @Override
    public ServerResponse<PageInfo<Log>> getLogPage(Integer pageNum) {
        PageHelper.startPage(pageNum,8);
        List<Log> list = logMapper.getLogList();
        PageInfo<Log> pageInfo = new PageInfo<>(list);
        if (list.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("返回成功",pageInfo);
    }

    @Override
    @SysLogAnnotation(operModel = "日志管理",operType = "删除",operDesc = "删除指定日志")
    public ServerResponse<String> deleteLogByLogId(Integer logId) {
        logMapper.deleteLogByLogId(logId);
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    @SysLogAnnotation(operModel = "日志管理",operType = "删除",operDesc = "批量删除日志")
    public ServerResponse<String> deleteLogByLogIds(List<Integer> logIds) {
        logMapper.deleteLogByLogIds(logIds);
        return ServerResponse.createBySuccessMessage("批量删除成功");
    }
}
