package com.wanli.community.service;

import com.wanli.community.entity.Parking;

import java.util.List;

public interface ParkingService {
    public Parking getParkingByParkingId(Integer parkingId);
    public List<Parking> listParking();

    public boolean update(Parking parking);

    public boolean updateState(Parking parking, Integer state);



}
