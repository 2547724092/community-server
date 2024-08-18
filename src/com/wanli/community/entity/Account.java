package com.wanli.community.entity;

import java.time.LocalDateTime;

public class Account {
    private String accountId;
    private String password;
    private String accountName;
    private Integer accountSex;
    private String accountImg;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Integer state;
    private Integer del_tag;
    private Double money;

    private Housebind housebind;

    public Account() {
    }

    public Account(String accountId, String password, String accountName, Integer accountSex, String accountImg, LocalDateTime created, LocalDateTime updated, Integer state, Integer del_tag, Double money, Housebind housebind) {
        this.accountId = accountId;
        this.password = password;
        this.accountName = accountName;
        this.accountSex = accountSex;
        this.accountImg = accountImg;
        this.created = created;
        this.updated = updated;
        this.state = state;
        this.del_tag = del_tag;
        this.money = money;
        this.housebind = housebind;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAccountSex() {
        return accountSex;
    }

    public void setAccountSex(Integer accountSex) {
        this.accountSex = accountSex;
    }

    public String getAccountImg() {
        return accountImg;
    }

    public void setAccountImg(String accountImg) {
        this.accountImg = accountImg;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDel_tag() {
        return del_tag;
    }

    public void setDel_tag(Integer del_tag) {
        this.del_tag = del_tag;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Housebind getHousebind() {
        return housebind;
    }

    public void setHousebind(Housebind housebind) {
        this.housebind = housebind;
    }
}
