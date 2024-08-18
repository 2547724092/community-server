package com.wanli.community.service.impl;

import com.wanli.community.dao.ParkingDao;
import com.wanli.community.dao.impl.ParkingDaoImpl;
import com.wanli.community.entity.Parking;
import com.wanli.community.service.ParkingService;

import java.util.List;

public class ParkingServiceImpl implements ParkingService {
    ParkingDao dao = new ParkingDaoImpl();
    @Override
    public Parking getParkingByParkingId(Integer parkingId) {
        return dao.select(parkingId);
    }

    @Override
    public List<Parking> listParking() {
        return dao.select();
    }

    @Override
    public boolean update(Parking parking) {
        return dao.update(parking) > 0;
    }

    @Override
    public boolean updateState(Parking parking, Integer state){
        parking.setState(state);
        return dao.updateState(parking) > 0;
    }
}
