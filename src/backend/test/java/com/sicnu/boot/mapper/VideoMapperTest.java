package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Video;
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
        List<Video> list = videoMapper.getVideoListBySelective();
        list.forEach(System.out :: println);
    }
}
