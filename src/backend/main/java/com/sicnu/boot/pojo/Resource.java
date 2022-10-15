package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:  资源实体类
 *
 * @author :  胡建华
 * Data:    2022/10/15 14:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {
    private Integer resourceId;
    private String name;
    private Integer type;
    private String introduce;
}
