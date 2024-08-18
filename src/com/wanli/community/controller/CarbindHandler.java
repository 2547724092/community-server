package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.Carbind;
import com.wanli.community.entity.Parking;
import com.wanli.community.service.CarbindService;
import com.wanli.community.service.impl.CarbindServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class CarbindHandler {
    private CarbindService service = new CarbindServiceImpl();

    public Result listCarbindByAccountId(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");
        List<Carbind> list = service.listCarbindByAccountId(accountId);

        if (list != null) {
            return Result.success(20000, "车位绑定信息获取成功", list);
        } else {
            return Result.fail("车位绑定信息获取失败");
        }
    }

    public Result getCarbindByCarbindId(HttpServletRequest request) {
        Integer carbindId = Integer.valueOf(request.getParameter("carbindId"));
        Carbind carbind = service.getCarbindByCarbindId(carbindId);

        if (carbind != null) {
            return Result.success(20000, "车位绑定信息获取成功", carbind);
        } else {
            return Result.fail("车位绑定信息获取失败");
        }
    }

    public Result save(HttpServletRequest request) {
        Integer parkingId = Integer.valueOf(request.getParameter("parkingId"));
        Integer carId = Integer.valueOf(request.getParameter("carId"));
        Timestamp carbindEnd = Timestamp.valueOf(request.getParameter("carbindEnd"));
        Double payment = Double.valueOf(request.getParameter("payment"));

        Carbind carbind = new Carbind();
        carbind.setParkingId(parkingId);
        carbind.setCarId(carId);

        Parking parking = new Parking();
        parking.setParkingId(parkingId);
        carbind.setParking(parking);

        carbind.setCarbindEnd(carbindEnd.toLocalDateTime());
        carbind.setPayment(payment);
//        carbind.setReviewerId(reviewerId);
//        carbind.setState(state);

        if (service.save(carbind) != null) {
            return Result.success(20000, "添加车位绑定信息成功", carbind);
        } else {
            return Result.fail("添加车位绑定信息失败");
        }
    }

    public Result del(HttpServletRequest request){
        Integer carbindId = Integer.valueOf(request.getParameter("carbindId"));

        Carbind carbind = new Carbind();
        carbind.setCarbindId(carbindId);

        if(service.del(carbind)){
            return Result.success(20000, "删除车位绑定信息成功", carbind);
        } else {
            return Result.fail("删除车位绑定信息失败");
        }
    }
}
