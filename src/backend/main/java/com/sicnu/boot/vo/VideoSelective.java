package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

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
    @Size(min = 1,message = "页数最小为1")
    private Integer pageNum;
    @Size(min = 1,max = 15,message = "分页的每页大小必须为1-15")
    private Integer pageSize;
    @Length(min = 1,max = 20,message = "视频名称大小必须为1-20")
    private String videoName;
    @Length(min = 1,max = 10,message = "视频类型长度必须为1-10")
    private String videoType;
    @Size(min = 1,message = "视频时长最小值为1")
    private Integer videoDuration;
    @Min(value = 0,message = "排序最小值必须为0")
    private Integer videoSort;
    private String videoSortName;
}
