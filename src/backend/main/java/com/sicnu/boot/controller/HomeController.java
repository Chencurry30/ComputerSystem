package com.sicnu.boot.controller;

import com.sicnu.boot.service.HomeService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * description:  首页
 *
 * @author :  胡建华
 * Data:    2022/12/13 19:16
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Resource
    private HomeService homeService;

    @GetMapping("/search")
    public ServerResponse<Map<String,Object>> search(String name){
        return homeService.search(name);
    }
}
