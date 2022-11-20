package com.sicnu.boot.controller;

import com.sicnu.boot.service.OssService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * description:  TODO
 *
 * @author :  胡建华
 * Data:    2022/11/19 14:44
 */
@RestController
@RequestMapping("/oss")
public class OssController {

    @Resource
    private OssService ossService;

    /**
     * description: 用户上传头像的代理
     *
     * @param fileName:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/19 21:48
     */
    @CrossOrigin
    @GetMapping("/policy/user/{fileName}")
    public ServerResponse<Map<String, String>> policy(@PathVariable String fileName){
        return ossService.policy(fileName);
    }
}
