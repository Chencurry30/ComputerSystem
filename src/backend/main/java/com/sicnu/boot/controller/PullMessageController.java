package com.sicnu.boot.controller;

import com.sicnu.boot.utils.RedisUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/03 16:40
 */
@RestController
@RequestMapping("/pull")
public class PullMessageController {
    @Resource
    private RedisUtils redisUtils;

    @PostMapping("/msg")
    public List<Object> pullMsg(@RequestParam("from") Integer from, @RequestParam("to") Integer to) {
        // 根据两人的 id 生成键，并到 redis 中获取
        String key = IntStream.of(from, to)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("-"));
        return redisUtils.getCacheList(key);
    }

}
