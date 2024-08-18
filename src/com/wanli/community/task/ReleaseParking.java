package com.wanli.community.task;

import com.wanli.community.dao.CarbindDao;
import com.wanli.community.dao.ParkingDao;
import com.wanli.community.dao.impl.CarbindDaoImpl;
import com.wanli.community.dao.impl.ParkingDaoImpl;
import com.wanli.community.entity.Carbind;
import com.wanli.community.entity.Parking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class ReleaseParking extends TimerTask {
    // 释放车位
    private ParkingDao parkingDao = new ParkingDaoImpl();
    private CarbindDao carbindDao = new CarbindDaoImpl();
    @Override
    public void run() {
        System.out.println("ReleaseParking checking...");
        List<Carbind> carbindList = carbindDao.selectCarbind();
        for (Carbind carbind : carbindList){
            // 绑定车位时间一过 即刻释放
            if (LocalDateTime.now().isAfter(carbind.getCarbindEnd()) && carbind.getParking().getState() != 1){
                Parking parking = parkingDao.select(carbind.getParkingId());
                parking.setState(1);
                parkingDao.updateState(parking);
                System.out.println("ReleaseParkingId: " + carbind.getParkingId());
            }
        }
    }
}
