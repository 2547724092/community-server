package com.wanli.community.service;

import com.wanli.community.entity.House;

import java.util.List;

public interface HouseService {
    public List<House> listHouse();

    public House lisByHouseId(Integer houseId);
}
