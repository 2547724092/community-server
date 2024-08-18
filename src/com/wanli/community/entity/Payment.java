package com.wanli.community.entity;

import java.time.LocalDateTime;

public class Payment {
    private Integer paymentId;
    private String accountId;

    private Integer paymentType;

    private Integer relatedId;

    private Double amount;
    private Integer state;
    private LocalDateTime paymentTime;

    private Carbind carbind;
    private House house;

    public Payment() {
    }

    public Payment(Integer paymentId, String accountId, Integer paymentType, Integer relatedId, Double amount, Integer state, LocalDateTime paymentTime, Carbind carbind, House house) {
        this.paymentId = paymentId;
        this.accountId = accountId;
        this.paymentType = paymentType;
        this.relatedId = relatedId;
        this.amount = amount;
        this.state = state;
        this.paymentTime = paymentTime;
        this.carbind = carbind;
        this.house = house;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(Integer relatedId) {
        this.relatedId = relatedId;
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

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Carbind getCarbind() {
        return carbind;
    }

    public void setCarbind(Carbind carbind) {
        this.carbind = carbind;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
