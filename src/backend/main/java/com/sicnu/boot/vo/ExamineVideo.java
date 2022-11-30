package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/30 17:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamineVideo {
    /**
     * description: 审核id
     */
    @NotNull(message = "审核id不能为空")
    @Range(min = 1,message = "审核id最小为1")
    private Integer examineId;
    /**
     * description: 审核结果，1为通过，2为未通过
     */
    @NotNull(message = "审核结果不能为空")
    @Range(min = 1,max = 2,message = "审核结果必须为1或2")
    private Integer examineResult;
    /**
     * description: 审核意见
     */
    @NotNull(message = "审核意见不能为空")
    @NotBlank(message = "审核意见不能为空")
    private String reviewComment;
    /**
     * description: 审核时间
     */
    private LocalDateTime passDate;
    /**
     * description: 审核人
     */
    private Integer applyId;
}
