package com.sicnu.boot.pojo;

import com.sicnu.boot.group.Update;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 10:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @NotNull(message = "id不能为空",groups = {Update.class})
    private Integer roleId;
    @NotNull(message = "角色名不能为空")
    @NotBlank(message = "角色名不能为空")
    private String name;
    @NotNull(message = "roleKey不能为空")
    @NotBlank(message = "roleKey不能为空")
    private String roleKey;

    private List<Menu> menus;
}
