package com.wanli.community.entity;

public class Car {
    private Integer carId;
    private String carLicense;
    private String carImg;
    private String accountId;
    private String carType;

    public Car() {
    }

    public Car(Integer carId, String carLicense, String carImg, String accountId, String carType) {
        this.carId = carId;
        this.carLicense = carLicense;
        this.carImg = carImg;
        this.accountId = accountId;
        this.carType = carType;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
