package com.sicnu.boot.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/15 21:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionSelective {
    private Integer typeId;
    private Integer typeName;
    private Integer difficultId;
    private BigDecimal difficultMinValue;
    private BigDecimal difficultMaxValue;
    private Integer classifyId;
    private Integer sourceId;
    private String sourceName;
    private Integer yearId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yearName;
    private Integer pageNum;

    public QuestionSelective(Integer typeId, Integer difficultId, Integer classifyId, Integer sourceId, Integer yearId,Integer pageNum) {
        this.typeId = typeId;
        this.difficultId = difficultId;
        this.classifyId = classifyId;
        this.sourceId = sourceId;
        this.yearId = yearId;
        this.pageNum = pageNum;
    }
}
