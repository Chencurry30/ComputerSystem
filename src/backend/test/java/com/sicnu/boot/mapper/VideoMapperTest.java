package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Video;
import com.sicnu.boot.vo.VideoSelective;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/15 20:07
 */
@SpringBootTest
public class VideoMapperTest {
    @Resource
    private VideoMapper videoMapper;

    @Test
    void testGetVideoListBySelective(){
        VideoSelective selective = new VideoSelective(0,0,"考研","英语",null,1,"time");
        List<Video> list = videoMapper.getVideoListBySelective(selective);
        list.forEach(System.out :: println);
    }
}
