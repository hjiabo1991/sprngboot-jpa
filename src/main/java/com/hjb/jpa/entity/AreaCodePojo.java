package com.hjb.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "area_code")
public class AreaCodePojo {

    @Id
    @Column(name = "areacode")
    private String areaCode;
    @Column(name = "province")
    private String province;
    @Column(name = "city")
    private String city;
    @Column(name = "areaname")
    private String areaName;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "AreaCodePojo{" +
                "areaCode='" + areaCode + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
