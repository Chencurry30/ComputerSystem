package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Video;
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
     */
    List<Video> getVideoListBySelective();
}
