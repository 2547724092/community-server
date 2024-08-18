package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.Parking;
import com.wanli.community.service.ParkingService;
import com.wanli.community.service.impl.ParkingServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ParkingHandler {
    private ParkingService service = new ParkingServiceImpl();

    public Result listParkingById(HttpServletRequest request){
        Integer parkingId = Integer.valueOf(request.getParameter("parkingId"));
        Parking parking = service.getParkingByParkingId(parkingId);

        if (parking != null) {
            return Result.success(20000, "车位数据请求成功", parking);
        } else {
            return Result.fail("车位数据请求失败");
        }
    }

    public Result listParking(HttpServletRequest request) {
        List<Parking> list = service.listParking();

        if (list != null) {
            return Result.success(20000, "车位数据请求成功", list);
        } else {
            return Result.fail("车位数据请求失败");
        }
    }

    public Result updateState(HttpServletRequest request){
        Integer parkingId = Integer.valueOf(request.getParameter("parkingId"));
        Integer state = Integer.valueOf(request.getParameter("state"));

        if (state == null){
            state = 0;
        }

        Parking parking = new Parking();
        parking.setParkingId(parkingId);

        if (service.updateState(parking,state)){
            return Result.success(20000, "更新车位信息成功", parking);
        } else {
            return Result.fail("更新车位信息失败");
        }
    }
}
