package com.sicnu.boot.controller;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Log;
import com.sicnu.boot.service.LogService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/12 15:22
 */
@RestController
@RequestMapping("/admin/logs")
@Validated
public class LogController {

    @Resource
    private LogService logService;

    /**
     * description: 返回日志列表
     *
     * @param pageNum:
     * @return ServerResponse<PageInfo<Log>>
     * @author 胡建华
     * Date:  2022/11/12 15:39
     */
    @GetMapping("/pages/{pageNum}")
    ServerResponse<PageInfo<Log>> getLogPage(@Min(value = 1,message = "分页数最小为1")
                                             @PathVariable Integer pageNum){
        return logService.getLogPage(pageNum);
    }

    /**
     * description: 删除日志
     *
     * @param logId:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/12 15:46
     */
    @DeleteMapping("/{logId}")
    ServerResponse<String> deleteLogByLogId(@Min(value = 1,message = "logId最小为1")
                                            @PathVariable Integer logId){
        return logService.deleteLogByLogId(logId);
    }

    /**
     * description: 批量删除日志
     *
     * @param list:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/12 15:46
     */
    @PostMapping
    ServerResponse<String> deleteLogByLogIds(@Validated @RequestBody List<Log> list){
        List<Integer> logIds = new ArrayList<>();
        for (Log log : list) {
            logIds.add(log.getLogId());
        }
        return logService.deleteLogByLogIds(logIds);
    }
}
