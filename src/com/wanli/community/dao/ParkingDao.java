package com.wanli.community.dao;

import com.wanli.community.entity.Parking;

import java.util.List;

public interface ParkingDao {
    // 根据parkingId列出
    public Parking select(Integer parkingId);

    // 列出所有
    public List<Parking> select();

    public Integer update(Parking parking);

    public Integer updateState(Parking parking);
}
