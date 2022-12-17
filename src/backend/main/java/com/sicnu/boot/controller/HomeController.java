package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.service.HomeService;
import com.sicnu.boot.utils.ServerResponse;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

/**
 * description:  首页
 *
 * @author :  胡建华
 * Data:    2022/12/13 19:16
 */
@RestController
@RequestMapping("/home")
@Validated
public class HomeController {

    @Resource
    private HomeService homeService;

    /**
     * description: 首页查询
     *
     * @param name:
     * @return ServerResponse<Map<String,Object>>
     * @author 胡建华
     * Date:  2022/12/15 11:17
     */
    @GetMapping("/search")
    public ServerResponse<Map<String,Object>> search(@Length(min = 1,max = 15,message = "搜索名字长度只能为1-15")
            String name){
        return homeService.search(name.trim());
    }

    /**
     * description: 获取首页视频列表
     *
     * @param typeId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/15 11:32
     */
    @GetMapping("/video/{typeId}")
    public ServerResponse<List<Video>> getVideoListByType(@Min(value = 1,message = "typeId最小为1")
                                             @PathVariable Integer typeId){
        return homeService.getVideoListByType(typeId);
    }
}
