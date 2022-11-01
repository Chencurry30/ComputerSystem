package com.sicnu.boot.vo;

import com.sicnu.boot.pojo.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 21:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVo {
    @Min(value = 1,message = "roleId最小值为1")
    private Integer roleId;
    private List<Menu> menuList;
}
