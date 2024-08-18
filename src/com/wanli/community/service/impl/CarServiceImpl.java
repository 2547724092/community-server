package com.wanli.community.service.impl;

import com.wanli.community.dao.CarDao;
import com.wanli.community.dao.impl.CarDaoImpl;
import com.wanli.community.entity.Car;
import com.wanli.community.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    private CarDao dao = new CarDaoImpl();

    @Override
    public List<Car> listCarByAccountId(String accountId) {
        return dao.selectCarByAccountId(accountId);
    }

    @Override
    public Car getCarByCarId(Integer carId) {
        return dao.selectCarByCarId(carId);
    }

    @Override
    public boolean save(Car car) {
        return dao.insert(car) > 0;
    }

}
