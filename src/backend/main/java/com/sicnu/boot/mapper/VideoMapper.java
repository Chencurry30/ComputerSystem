package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.vo.VideoSelective;
import com.sicnu.boot.vo.VideoType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/15 19:58
 */
@Mapper
public interface VideoMapper {
    /**
     * description: 通过选择，返回视频列表
     *
     * @return List<Video>
     * @author 胡建华
     * Date:  2022/10/15 20:04
     * @param videoSelective :
     */
    List<Video> getVideoListBySelective(VideoSelective videoSelective);

    /**
     * description: 通过id获取视频详细信息
     *
     * @param videoId:
     * @return Video
     * @author 胡建华
     * Date:  2022/10/16 16:27
     */
    Video getVideoByVideoId(Integer videoId);

    /**
     * description: 获取视频的类型
     *
     * @return List<VideoType>
     * @author 胡建华
     * Date:  2022/10/25 18:40
     */
    List<VideoType> getVideoType();

    /**
     * description: 收藏视频
     *
     * @param userId:
     * @param videoId:
     * @author 胡建华
     * Date:  2022/11/23 18:52
     */
    void collectVideo(Integer userId, Integer videoId);

    /**
     * description: 检查该视频是否被收藏了
     *
     * @param userId:
     * @param videoId:
     * @return int
     * @author 胡建华
     * Date:  2022/11/23 18:54
     */
    int checkCollectVideo(Integer userId, Integer videoId);

    /**
     * description: 取消收藏
     *
     * @param userId:
     * @param videoId:
     * @author 胡建华
     * Date:  2022/11/23 19:11
     */
    void deleteCollectVideo(Integer userId, Integer videoId);

    /**
     * description: 获取一个用户的收藏列表
     *
     * @param userId:
     * @return List<Video>
     * @author 胡建华
     * Date:  2022/11/23 19:32
     */
    List<Video> getCollectVideoList(Integer userId);
}
