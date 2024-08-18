package com.wanli.community.dao;

import com.wanli.community.entity.House;

import java.util.List;

public interface HouseDao {
    public List<House> select();

    public House select(Integer houseId);
}
