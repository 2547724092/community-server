package com.wanli.community.entity;

import java.time.LocalDateTime;

public class PaymentHouse {
    private Integer paymentHouseId;
    private Integer houseId;
    private Double amount;
    private Integer state;
    private Integer amountType;
    private LocalDateTime paymentTime;

    private Housebind housebind;

    public PaymentHouse() {
    }

    public PaymentHouse(Integer paymentHouseId, Integer houseId, Double amount, Integer state, Integer amountType, LocalDateTime paymentTime, Housebind housebind) {
        this.paymentHouseId = paymentHouseId;
        this.houseId = houseId;
        this.amount = amount;
        this.state = state;
        this.amountType = amountType;
        this.paymentTime = paymentTime;
        this.housebind = housebind;
    }

    public Integer getPaymentHouseId() {
        return paymentHouseId;
    }

    public void setPaymentHouseId(Integer paymentHouseId) {
        this.paymentHouseId = paymentHouseId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAmountType() {
        return amountType;
    }

    public void setAmountType(Integer amountType) {
        this.amountType = amountType;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Housebind getHousebind() {
        return housebind;
    }

    public void setHousebind(Housebind housebind) {
        this.housebind = housebind;
    }
}
