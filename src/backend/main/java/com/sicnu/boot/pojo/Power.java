package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description:  权限实体类
 *
 * @author :  胡建华
 * Data:    2022/10/12 16:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Power implements Serializable {
    private static final long serialVersionUID = -54979041104113736L;

    private Integer id;
    private String perms;

}
