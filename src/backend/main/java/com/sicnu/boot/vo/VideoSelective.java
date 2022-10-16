package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:  
 *
 * @author :  胡建华
 * Data:    2022/10/16 9:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoSelective {
    private Integer pageNum;
    private Integer pageSize;
    private String videoName;
    private String videoType;
    private Integer videoDuration;
    private Integer videoSort;
    private String videoSortName;
}
