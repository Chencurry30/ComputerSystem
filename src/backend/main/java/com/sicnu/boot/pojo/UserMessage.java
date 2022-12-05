package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * description:  用户聊天实体类
 *
 * @author :  胡建华
 * Data:    2022/12/03 15:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMessage {
    /**
     * description: 发送者的 id
     */
    private Integer from;
    /**
     * description: 接受者的 id
     */
    private Integer to;
    /**
     * description: 具体信息
     */
    private String message;
    /**
     * description: 发送时间
     */
    private Date time;
}
