package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/25 21:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollegeRegion {
    private Integer regionId;
    private String regionName;
    private Integer id;
    private String name;

    public CollegeRegion(Integer regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.name = regionName;
        this.id = regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
        this.id = regionId;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
        this.name = regionName;
    }
}
