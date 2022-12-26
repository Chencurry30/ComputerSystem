package com.sicnu.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.aop.SysLogAnnotation;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.mapper.VideoMapper;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.pojo.VideoExamine;
import com.sicnu.boot.service.VideoManageService;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.ExamineVideo;
import com.sicnu.boot.vo.LoginUser;
import com.sicnu.boot.vo.VideoSelective;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/30 16:13
 */
@Service
@Slf4j
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
        if (list.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("成功",pageInfo);
    }

    @Override
    @SysLogAnnotation(operModel = "视频管理",operType = "删除",operDesc = "删除指定视频")
    public ServerResponse<String> deleteVideoById(Integer videoId) {
        Video video = videoMapper.getVideoByVideoId(videoId);
        if (!Objects.isNull(video)){
            videoMapper.deleteResource(video.getResourceId());
            videoMapper.deleteVideoById(videoId);
        }
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse<PageInfo<VideoExamine>> getVideoExamineList(Integer pageNum, Integer examineStatus) {
        PageHelper.startPage(pageNum,8);
        List<VideoExamine> list = videoMapper.getVideoExamineList(examineStatus);
        list.forEach(videoExamine -> {
            videoExamine.setAuthorNickname(
                    userMapper.getNicknameByUserId(videoExamine.getAuthorId()));
            videoExamine.setApplyNickname(
                    userMapper.getNicknameByUserId(videoExamine.getApplyId()));
        });
        PageInfo<VideoExamine> pageInfo = new PageInfo<>(list);
        if (list.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @SysLogAnnotation(operModel = "视频模块",operType = "审核",operDesc = "审核指定视频")
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
            log.info("审核通过");
            return ServerResponse.createBySuccessMessage("审核通过");
        }else {
            log.info("审核不通过，原因是：{}",examineVideo.getReviewComment());
            return ServerResponse.createBySuccessMessage("审核未通过");
        }
    }


}
