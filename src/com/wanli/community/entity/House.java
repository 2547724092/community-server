package com.wanli.community.entity;

public class House {
    private Integer houseId;
    private String houseAddress;

    public House() {
    }

    public House(Integer houseId, String houseAddress) {
        this.houseId = houseId;
        this.houseAddress = houseAddress;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }
}
