package com.wanli.community.entity;

public class Parking {
    private Integer parkingId;
    private String parkingArea;
    private Integer parkingNumber;
    private Integer state;

    public Parking() {
    }

    public Parking(Integer parkingId, String parkingArea, Integer parkingNumber, Integer state) {
        this.parkingId = parkingId;
        this.parkingArea = parkingArea;
        this.parkingNumber = parkingNumber;
        this.state = state;
    }

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public String getParkingArea() {
        return parkingArea;
    }

    public void setParkingArea(String parkingArea) {
        this.parkingArea = parkingArea;
    }

    public Integer getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(Integer parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
