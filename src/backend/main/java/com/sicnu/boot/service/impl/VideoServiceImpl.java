package com.sicnu.boot.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.mapper.VideoMapper;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.service.VideoService;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.VideoSelective;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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

    @Resource
    private UserMapper userMapper;

    @Override
    public ServerResponse<PageInfo<Video>> getVideoListBySelective(VideoSelective videoSelective) {
        //设置排序名字
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
        //获取分页信息
        PageHelper.startPage(videoSelective.getPageNum(), videoSelective.getPageSize());
        List<Video> list = videoMapper.getVideoListBySelective(videoSelective);
        for (Video video : list) {
            //查询作者昵称
            String nickname = userMapper.getNicknameByUserId(video.getAuthorId());
            //未查询到作者，返回空字符串
            if (StringUtils.isBlank(nickname)) {
                nickname = "";
            }
            video.setNickname(nickname);
        }
        PageInfo<Video> pageInfo = new PageInfo<>(list);
        return ServerResponse.createBySuccess("成功",pageInfo);
    }

    @Override
    public ServerResponse<Video> getVideoByVideoId(Integer videoId) {
        Video video = videoMapper.getVideoByVideoId(videoId);
        if (Objects.isNull(video)){
            return ServerResponse.createByErrorMessage("未查询到此视频");
        }
        String nickname = userMapper.getNicknameByUserId(video.getAuthorId());
        //未查询到作者，返回空字符串
        if (StringUtils.isBlank(nickname)){
            nickname = "";
        }
        video.setNickname(nickname);
        return ServerResponse.createBySuccess("获取成功",video);
    }
}
