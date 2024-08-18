package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.Car;
import com.wanli.community.service.CarService;
import com.wanli.community.service.impl.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CarHandler {
    private CarService service = new CarServiceImpl();


    public Result listCarByAccountId(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");

        List<Car> list = service.listCarByAccountId(accountId);

        if (list != null) {
            return Result.success(20000, "车辆数据请求成功", list);
        } else {
            return Result.fail("车辆数据请求失败");
        }
    }

    public Result getCarByCarId(HttpServletRequest request) {
        Integer carId = Integer.valueOf(request.getParameter("carId"));
        Car car = service.getCarByCarId(carId);

        if (car != null) {
            return Result.success(20000, "车辆数据请求成功", car);
        } else {
            return Result.fail("车辆数据请求失败");
        }
    }

    public Result save(HttpServletRequest request){
        String carLicense = request.getParameter("carLicense");
        String carImg = request.getParameter("carImg");
        String accountId = (request.getParameter("accountId"));
        String carType = request.getParameter("carType");

        Car car = new Car();
        car.setCarLicense(carLicense);
        car.setCarImg(carImg);
        car.setAccountId(accountId);
        car.setCarType(carType);

        if (service.save(car)){
            return Result.success(20000, "车辆添加成功", car);
        } else {
            return Result.fail("车辆添加失败");
        }
    }
}
