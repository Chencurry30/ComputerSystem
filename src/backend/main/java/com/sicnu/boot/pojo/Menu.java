package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sicnu.boot.group.Update;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

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
public class Menu implements Serializable {
    private static final long serialVersionUID = -54979041104113736L;
    @NotNull(message = "权限id不能为空",groups = {Update.class})
    private Integer menuId;
    @NotNull(message = "path不能为空")
    @NotNull(message = "path不能为空字符串")
    private String path;
    @NotNull(message = "path不能为空")
    @NotNull(message = "path不能为空字符串")
    private String name;
    @NotNull(message = "path不能为空")
    @NotNull(message = "path不能为空字符串")
    private String component;
    private Integer parentId;
    @Range(min = 0,max = 1,message = "menuType必须为0或1")
    private Integer menuType;
    private Integer level;
    private String label;
    private String perms;
    private List<Menu> children;

    public void setName(String name) {
        this.name = name;
        this.label = name;
    }
}
