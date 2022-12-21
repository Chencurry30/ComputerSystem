package com.sicnu.boot.controller;

import com.sicnu.boot.service.HomeManageService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/20 9:32
 */
@RestController
@RequestMapping("/admin/home")
public class HomeManageController {
    @Resource
    private HomeManageService homeManageService;

    @GetMapping("/counts")
    ServerResponse<Map<String,Map<String,Integer>>> getHomeCounts(){
        return homeManageService.getHomeCounts();
    }

}
