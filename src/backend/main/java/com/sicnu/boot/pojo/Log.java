package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @Min(value = 1,message = "logId最小为1")
    @NotNull(message = "logId不能为空")
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
