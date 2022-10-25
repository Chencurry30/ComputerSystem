package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

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
    private String videoName;
    private Integer typeId;
    private Integer durationId;
    private Integer durationValue;
    private Integer sortId;
    private String sortName;
    private Integer pageNum;


    public VideoSelective(String videoName, Integer typeId, Integer durationId, Integer sortId, Integer pageNum) {
        this.videoName = videoName;
        this.typeId = typeId;
        this.durationId = durationId;
        this.sortId = sortId;
        this.pageNum = pageNum;
    }
}
