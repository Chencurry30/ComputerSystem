package com.sicnu.boot.pojo;

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
public class Video {
  private Integer videoId;
  private String name;
  private LocalDateTime time;
  private Integer likeNumber;
  private String introduction;
  private Integer resourceId;
  private String image;
  private Integer collectionNum;
  private Integer viewNum;
  private String typeOne;
  private String typeTwo;
  private String typeThree;
  private Integer duration;

}
