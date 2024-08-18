package com.wanli.community.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Housebind {
    private Integer housebindId;
    private Integer houseId;
    private String accountId;
    private LocalDateTime created;
    private LocalDateTime updated;


    private House house;

    public Housebind() {
    }

    public Housebind(Integer housebindId, Integer houseId, String accountId, LocalDateTime created, LocalDateTime updated, House house) {
        this.housebindId = housebindId;
        this.houseId = houseId;
        this.accountId = accountId;
        this.created = created;
        this.updated = updated;
        this.house = house;
    }

    public Integer getHousebindId() {
        return housebindId;
    }

    public void setHousebindId(Integer housebindId) {
        this.housebindId = housebindId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
