package com.wanli.community.service.impl;

import com.wanli.community.dao.CarDao;
import com.wanli.community.dao.CarbindDao;
import com.wanli.community.dao.ParkingDao;
import com.wanli.community.dao.PaymentDao;
import com.wanli.community.dao.impl.CarDaoImpl;
import com.wanli.community.dao.impl.CarbindDaoImpl;
import com.wanli.community.dao.impl.ParkingDaoImpl;
import com.wanli.community.dao.impl.PaymentDaoImpl;
import com.wanli.community.entity.Car;
import com.wanli.community.entity.Carbind;
import com.wanli.community.entity.Parking;
import com.wanli.community.entity.Payment;
import com.wanli.community.service.CarbindService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarbindServiceImpl implements CarbindService {
    private CarbindDao carbindDao = new CarbindDaoImpl();
    private ParkingDao parkingDao = new ParkingDaoImpl();
    private CarDao carDao = new CarDaoImpl();

    private PaymentDao paymentDao = new PaymentDaoImpl();

    @Override
    public List<Carbind> listCarbindByAccountId(String accountId) {
        List<Carbind> list = carbindDao.select(accountId);
        for (Carbind carbind : list) {
            Integer parkingId = carbind.getParkingId();
            Parking parking = parkingDao.select(parkingId);
            carbind.setParking(parking);

            Integer carId = carbind.getCarId();
            Car car = carDao.selectCarByCarId(carId);
            carbind.setCar(car);
        }
        return list;
    }

    @Override
    public Carbind getCarbindByCarbindId(Integer carbindId) {
        Carbind carbind = carbindDao.select(carbindId);

        Integer parkingId = carbind.getParkingId();
        Parking parking = parkingDao.select(parkingId);
        carbind.setParking(parking);

        Integer carId = carbind.getCarId();
        Car car = carDao.selectCarByCarId(carId);
        carbind.setCar(car);

        return carbind;
    }

    @Override
    public Integer save(Carbind carbind) {

        // 设置车位占用转态为已被占用 不可使用
        Parking parking = parkingDao.select(carbind.getParkingId());
        parking.setState(0);
        parkingDao.updateState(parking);

        // 保存车位信息 获得自增Id
        Integer carbindId = carbindDao.insert(carbind);


        // 更新缴费表内容
        Car car = carDao.selectCarByCarId(carbind.getCarId());
        Payment payment = new Payment();
        payment.setAccountId(car.getAccountId());
        payment.setPaymentType(0);


        payment.setRelatedId(carbindId);
        payment.setAmount(carbind.getPayment());
        payment.setState(0);
        payment.setPaymentTime(LocalDateTime.now());
        paymentDao.insertPayment(payment);



        return carbindId;
    }

    @Override
    public boolean del(Carbind carbind) {
        return carbindDao.del(carbind) > 0;
    }
}
