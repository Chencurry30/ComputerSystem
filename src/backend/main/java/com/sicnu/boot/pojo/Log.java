package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * description:  
 *
 * @author :  胡建华
 * Data:    2022/11/11 20:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private Integer logId;
    private String username;
    private String method;
    private String ip;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
    private String type;
    private String model;
    private String result;
    private String description;
    private String url;
}
