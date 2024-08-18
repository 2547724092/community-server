package com.wanli.community.service;

import com.wanli.community.entity.Car;

import java.util.List;

public interface CarService {
    public List<Car> listCarByAccountId(String accountId);

    public Car getCarByCarId(Integer carId);

    public boolean save(Car car);

}
