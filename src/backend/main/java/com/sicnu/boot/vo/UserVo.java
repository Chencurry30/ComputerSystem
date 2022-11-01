package com.sicnu.boot.vo;


import com.sicnu.boot.pojo.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/01 18:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    @Min(value = 1,message = "userId最小值为1")
    private Integer userId;
    @Valid
    private List<Role> roleList;
}
