package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.House;
import com.wanli.community.service.HouseService;
import com.wanli.community.service.impl.HouseServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class HouseHandler {
    HouseService service = new HouseServiceImpl();

    public Result listHouse(HttpServletRequest request) {
        List<House> list = service.listHouse();
        if (list != null) {
            return Result.success(20000, "房屋信息请求成功", list);
        } else {
            return Result.fail("房屋信息请求成功");
        }

    }

    public Result listByHouseId(HttpServletRequest request) {
        Integer houseId = Integer.valueOf(request.getParameter("houseId"));

        House house = service.lisByHouseId(houseId);
        if (house != null) {
            return Result.success(20000, "房屋信息请求成功", house);
        } else {
            return Result.fail("房屋信息请求成功");
        }
    }
}
