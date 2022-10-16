package com.sicnu.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.sicnu.boot.mapper.VideoMapper;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.service.VideoService;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.VideoSelective;
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
    public ServerResponse<List<Video>> getVideoListBySelective(VideoSelective videoSelective) {
        switch (videoSelective.getVideoSort()){
            case 0 : {
                videoSelective.setVideoSortName("");
                break;
            }
            case 1 : {
                videoSelective.setVideoSortName("duration");
                break;
            }
            case 2 : {
                videoSelective.setVideoSortName("time");
                break;
            }
            case 3 : {
                videoSelective.setVideoSortName("view_num");
                break;
            }
            case 4 : {
                videoSelective.setVideoSortName("comment_num");
                break;
            }
            default:{
                return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), "参数异常");
            }
        }
        PageHelper.startPage(videoSelective.getPageNum(),videoSelective.getPageSize());
        List<Video> list = videoMapper.getVideoListBySelective(videoSelective);
        return ServerResponse.createBySuccess("成功",list);
    }
}
