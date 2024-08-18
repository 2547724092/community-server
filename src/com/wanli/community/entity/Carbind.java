package com.wanli.community.entity;

import java.time.LocalDateTime;

public class Carbind {
    private Integer carbindId;
    private Integer parkingId;
    private Integer carId;

    private LocalDateTime carbindStart;
    private LocalDateTime carbindEnd;

    private Double payment;
    private String reviewerId;

    private Integer state;


    private Parking parking;
    private Car car;

    public Carbind() {
    }

    public Carbind(Integer carbindId, Integer parkingId, Integer carId, LocalDateTime carbindStart, LocalDateTime carbindEnd, Double payment, String reviewerId, Integer state, Parking parking, Car car) {
        this.carbindId = carbindId;
        this.parkingId = parkingId;
        this.carId = carId;
        this.carbindStart = carbindStart;
        this.carbindEnd = carbindEnd;
        this.payment = payment;
        this.reviewerId = reviewerId;
        this.state = state;
        this.parking = parking;
        this.car = car;
    }

    public Integer getCarbindId() {
        return carbindId;
    }

    public void setCarbindId(Integer carbindId) {
        this.carbindId = carbindId;
    }

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public LocalDateTime getCarbindStart() {
        return carbindStart;
    }

    public void setCarbindStart(LocalDateTime carbindStart) {
        this.carbindStart = carbindStart;
    }

    public LocalDateTime getCarbindEnd() {
        return carbindEnd;
    }

    public void setCarbindEnd(LocalDateTime carbindEnd) {
        this.carbindEnd = carbindEnd;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
