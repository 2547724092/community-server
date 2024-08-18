package com.wanli.community.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Bill {
    Integer billId;
    String accountId;
    Double amount;
    LocalDateTime billTime;
    Integer billType;

    public Bill() {
    }

    public Bill(Integer billId, String accountId, Double amount, LocalDateTime billTime, Integer billType) {
        this.billId = billId;
        this.accountId = accountId;
        this.amount = amount;
        this.billTime = billTime;
        this.billType = billType;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getBillTime() {
        return billTime;
    }

    public void setBillTime(LocalDateTime billTime) {
        this.billTime = billTime;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }
}
