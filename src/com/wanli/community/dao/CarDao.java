package com.wanli.community.dao;

import com.wanli.community.entity.Car;

import java.util.List;

public interface CarDao {
    // 根据accountId查询车辆信息 (多条数据)
    public List<Car> selectCarByAccountId(String accountId);

    // 根据carId查询车辆信息 (1条数据)
    public Car selectCarByCarId(Integer carId);

    public Integer insert(Car car);
}
