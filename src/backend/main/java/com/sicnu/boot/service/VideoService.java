package com.sicnu.boot.service;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.pojo.VideoExamine;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.VideoSelective;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/15 20:15
 */
public interface VideoService {

    /**
     * description: 通过选择，返回视频列表
     *
     * @param  videoSelective :
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/15 20:26
     */
    ServerResponse<PageInfo<Video>> getVideoListBySelective(VideoSelective videoSelective);

    /**
     * description: 获取视频分类筛选框
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/25 18:04
     */
    ServerResponse<List<Map<String,Object>>> getFilterBox();

    /**
     * description: 通过id获取视频详细信息
     *
     * @param videoId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/16 16:32
     */
    ServerResponse<Video> getVideoByVideoId(Integer videoId);

    /**
     * description: 收藏视频，或取消收藏视频
     *
     * @param videoId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/23 18:49
     */
    ServerResponse<String> collectVideo(Integer videoId);

    /**
     * description: 获取用户的收藏列表
     *
     * @param pageNum :
     * @param userId :
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/23 19:29
     */
    ServerResponse<PageInfo<Video>> getCollectVideoList(Integer pageNum,Integer userId);

    /**
     * description: 审核视频
     *
     * @param videoExamine:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/30 15:49
     */
    ServerResponse<String> uploadVideo(VideoExamine videoExamine);


}
