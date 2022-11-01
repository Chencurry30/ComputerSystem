package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sicnu.boot.group.Insert;
import com.sicnu.boot.group.Update;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {
    @NotNull(message = "id不能为空")
    @Min(value = 1,message = "roleId最小值为1")
    private Integer roleId;
    @NotNull(message = "角色名不能为空",groups = {Insert.class,Update.class})
    @NotBlank(message = "角色名不能为空",groups = {Insert.class,Update.class})
    @Length(min = 1,max = 20,message = "角色名长度必须为1-20")
    private String name;
    @NotNull(message = "roleKey不能为空",groups = {Insert.class,Update.class})
    @NotBlank(message = "roleKey不能为空",groups = {Insert.class,Update.class})
    @Length(min = 1,max = 35,message = "roleKey长度必须为1-35")
    private String roleKey;

    private List<Menu> menus;
}
