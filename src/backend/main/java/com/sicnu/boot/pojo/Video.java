package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * description: 视频实体类
 *
 * @author 胡建华
 * Date:  2022/10/15 14:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Video {
  private Integer id;
  private Integer videoId;
  private String name;
  @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime time;
  private Integer likeNumber;
  private String introduction;
  private Integer resourceId;
  private Integer authorId;
  private String image;
  private Integer collectionNum;
  private Integer viewNum;
  private String typeName;
  private Integer typeId;
  private Integer duration;
  private String link;
  private Integer commentNum;
  private String nickname;
  private Boolean isCollected;
}
