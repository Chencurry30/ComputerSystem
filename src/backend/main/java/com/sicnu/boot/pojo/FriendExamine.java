package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sicnu.boot.group.Insert;
import com.sicnu.boot.group.Update;
import com.sicnu.boot.vo.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * description:  好友审核
 *
 * @author :  胡建华
 * Data:    2022/12/06 10:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendExamine {
    private Integer examineId;
    private Integer userId;
    private UserDetail user;
    @NotNull(message = "请求的好友id不能为null")
    @Min(value = 1,message = "请求的好友id最小为1")
    private Integer friendId;
    private UserDetail friend;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    @NotNull(message = "好友状态不能为空",groups = {Update.class})
    @Range(min = 1,max = 2,message = "好友状态只能为1或2")
    private Integer status;
    @NotNull(message = "请求原因不能为null",groups = {Insert.class})
    @Length(min = 1,max = 255,message = "请求原因的长度最小为1，最大为255")
    private String reason;
}
