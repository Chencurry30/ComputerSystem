package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/20 10:01
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Major {
    private Integer majorId;
    private String name;
    private Integer majorCode;
    private Integer classifyId;
    private String classify;
    private String instruction;
}
