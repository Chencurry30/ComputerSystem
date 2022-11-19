package com.sicnu.boot.controller;

import com.sicnu.boot.service.OssService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @GetMapping("/policy/{fileName}")
    public ServerResponse policy(@PathVariable String fileName){
        return ossService.policy(fileName);
    }
}
