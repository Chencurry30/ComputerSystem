package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author 蔡名展
 * @version 1.0
 * description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {
    private Integer collegeId;
    private String name;
    private String address;
    private String type;
    private String region;
    private String phone;
    private Integer rank;
    private String disDevelop;


    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getDisDevelop() {
        return disDevelop;
    }

    public void setDisDevelop(String disDevelop) {
        this.disDevelop = disDevelop;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeId=" + collegeId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", region='" + region + '\'' +
                ", phone='" + phone + '\'' +
                ", rank=" + rank +
                ", disDevelop='" + disDevelop + '\'' +
                '}';
    }
}
