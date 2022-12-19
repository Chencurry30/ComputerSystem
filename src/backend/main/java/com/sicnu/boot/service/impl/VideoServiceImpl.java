package com.sicnu.boot.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.mapper.VideoMapper;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.pojo.VideoExamine;
import com.sicnu.boot.service.VideoService;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.utils.VideoUtils;
import com.sicnu.boot.vo.LoginUser;
import com.sicnu.boot.vo.VideoSelective;
import com.sicnu.boot.vo.VideoType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;

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
        videoSelective.setDurationValue(VideoUtils.getDurationById(videoSelective.getDurationId()));
        videoSelective.setSortName(VideoUtils.getSortById(videoSelective.getSortId()));
        //获取分页信息
        PageHelper.startPage(videoSelective.getPageNum(), 12);
        List<Video> list = videoMapper.getVideoListBySelective(videoSelective);
        list.forEach(video -> {
            String nickname = userMapper.getNicknameByUserId(video.getAuthorId());
            if (StringUtils.isBlank(nickname)) {
                nickname = "";
            }
            video.setNickname(nickname);
        });
        PageInfo<Video> pageInfo = new PageInfo<>(list);
        if (list.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("成功",pageInfo);
    }

    @Override
    public ServerResponse<List<Map<String,Object>>> getFilterBox() {
        List<Map<String,Object>> list = new ArrayList<>();
        //添加分类筛选
        List<VideoType> videoType = videoMapper.getVideoType();
        videoType.add(new VideoType(0,"全部"));
        videoType.sort(Comparator.comparingInt(VideoType::getTypeId));
        Map<String,Object> videoMap = new HashMap<>(5);
        videoMap.put("list",videoType);
        videoMap.put("id",2432212);
        videoMap.put("name","分类");
        list.add(videoMap);
        //添加时长筛选
        Map<String,Object> durationMap = new HashMap<>(5);
        durationMap.put("list", VideoUtils.getDurationList());
        durationMap.put("id",1343123);
        durationMap.put("name","时长");
        list.add(durationMap);
        //添加排序筛选
        Map<String,Object> sortMap = new HashMap<>(5);
        sortMap.put("list", VideoUtils.getSortList());
        sortMap.put("id",1223423);
        sortMap.put("name","排列");
        list.add(sortMap);
        return ServerResponse.createBySuccess("获取成功",list);
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
        //查看该视频是否被用户收藏
        //获取SecurityContextHolder中的用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userId = loginUser.getUser().getUserId();
        int checkCollectVideo = videoMapper.checkCollectVideo(userId, videoId);
        video.setIsCollected(checkCollectVideo > 0);
        //视频浏览数加1
        videoMapper.updateAddViewNum(videoId);
        return ServerResponse.createBySuccess("获取成功",video);
    }

    @Override
    public ServerResponse<String> collectVideo(Integer videoId) {
        //获取SecurityContextHolder中的用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userId = loginUser.getUser().getUserId();
        int checkCollectVideo = videoMapper.checkCollectVideo(userId, videoId);
        if (checkCollectVideo > 0){
            videoMapper.deleteCollectVideo(userId,videoId);
            //视频收藏数改变
            videoMapper.updateCollectNum(videoId,1);
            return ServerResponse.createBySuccessMessage("取消收藏成功");
        }
        videoMapper.updateCollectNum(videoId,0);
        videoMapper.collectVideo(userId,videoId);
        return ServerResponse.createBySuccessMessage("收藏成功");
    }

    @Override
    public ServerResponse<PageInfo<Video>> getCollectVideoList(Integer pageNum, Integer userId) {
        PageHelper.startPage(pageNum,8);
        List<Video> videoList = videoMapper.getCollectVideoList(userId);
        for (Video video : videoList) {
            String nickname = userMapper.getNicknameByUserId(video.getAuthorId());
            //未查询到作者，返回空字符串
            if (StringUtils.isBlank(nickname)){
                nickname = "";
            }
            video.setNickname(nickname);
        }
        PageInfo<Video> pageInfo = new PageInfo<>(videoList);
        if (videoList.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }

    @Override
    public ServerResponse<String> uploadVideo(VideoExamine videoExamine) {
        String videoTypeName = videoMapper.getVideoTypeName(videoExamine.getTypeId());
        if (StringUtils.isBlank(videoTypeName)){
            return ServerResponse.createByErrorMessage("不存在该视频类型");
        }
        videoExamine.setTypeName(videoTypeName);
        //设置上传时间
        videoExamine.setTime(LocalDateTime.now());
        //设置作者
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        videoExamine.setAuthorId(((LoginUser)authentication.getPrincipal()).getUser().getUserId());
        videoMapper.insertVideoExamine(videoExamine);
        return ServerResponse.createBySuccessMessage("申请上传视频成功");
    }
}
