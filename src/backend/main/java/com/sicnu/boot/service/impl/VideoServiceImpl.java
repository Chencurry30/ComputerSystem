package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.VideoMapper;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.service.VideoService;
import com.sicnu.boot.utils.ServerResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/15 20:15
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Resource
    private VideoMapper videoMapper;

    @Override
    public ServerResponse<List<Video>> getVideoListBySelective() {
        List<Video> list = videoMapper.getVideoListBySelective();
        return ServerResponse.createBySuccess("成功",list);
    }
}
