package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/30 15:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoExamine {
    private Integer examineId;
    private Integer resourceId;
    @NotNull(message = "视频名称不能为空")
    @NotBlank(message = "视频名称不能为空字符串")
    private String name;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    @NotNull(message = "视频介绍不能为空")
    @NotBlank(message = "视频介绍不能为空字符串")
    private String introduction;
    private Integer authorId;
    private String authorNickname;
    @NotNull(message = "视频图片不能为空")
    @NotBlank(message = "视频图片不能为空字符串")
    private String image;
    @NotNull(message = "视频种类不能为空")
    @Min(value = 1,message = "视频种类id最小为1")
    private Integer typeId;
    private String typeName;
    @NotNull(message = "视频时长不能为空")
    @Min(value = 1,message = "视频时长最小为1")
    private Integer duration;
    @NotNull(message = "视频链接不能为空")
    @NotBlank(message = "视频链接不能为空字符串")
    private String link;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime passDate;
    private Integer examineStatus;
    private Integer applyId;
    private String applyNickname;
    private String reviewComment;
}
