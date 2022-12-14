package com.sicnu.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.mapper.VideoMapper;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.pojo.VideoExamine;
import com.sicnu.boot.service.VideoManageService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.ExamineVideo;
import com.sicnu.boot.vo.LoginUser;
import com.sicnu.boot.vo.VideoSelective;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/30 16:13
 */
@Service
public class VideoManageServiceImpl implements VideoManageService {

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public ServerResponse<PageInfo<Video>> getVideoList(Integer pageNum, Integer typeId) {
        VideoSelective videoSelective = new VideoSelective();
        videoSelective.setTypeId(typeId);
        //获取分页信息
        PageHelper.startPage(pageNum, 8);
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
    public ServerResponse<String> deleteVideoById(Integer videoId) {
        Video video = videoMapper.getVideoByVideoId(videoId);
        videoMapper.deleteResource(video.getResourceId());
        videoMapper.deleteVideoById(videoId);
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse<PageInfo<VideoExamine>> getVideoExamineList(Integer pageNum, Integer examineStatus) {
        PageHelper.startPage(pageNum,8);
        List<VideoExamine> list = videoMapper.getVideoExamineList(examineStatus);
        list = list.stream().peek(videoExamine -> {
            videoExamine.setAuthorNickname(
                    userMapper.getNicknameByUserId(videoExamine.getAuthorId()));
            videoExamine.setApplyNickname(
                    userMapper.getNicknameByUserId(videoExamine.getApplyId()));
        }).collect(Collectors.toList());
        PageInfo<VideoExamine> pageInfo = new PageInfo<>(list);
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServerResponse<String> examineVideo(ExamineVideo examineVideo) {
        //设置审核时间
        examineVideo.setPassDate(LocalDateTime.now());
        //设置审核人
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        examineVideo.setApplyId(((LoginUser)authentication.getPrincipal()).getUser().getUserId());
        //修改审核信息
        videoMapper.examineVideo(examineVideo);
        if (examineVideo.getExamineResult() == 1){
            //审核通过
            //获取审核信息
            VideoExamine videoExamine = videoMapper.getVideoExamineById(examineVideo.getExamineId());
            //插入资源
            videoMapper.insertResource(videoExamine);
            //插入视频
            videoMapper.insertVideo(videoExamine);
            return ServerResponse.createBySuccessMessage("审核成功，插入视频");
        }else {
            return ServerResponse.createBySuccessMessage("审核未通过");
        }
    }


}
