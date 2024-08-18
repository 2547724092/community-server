package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.PaymentHouse;
import com.wanli.community.service.PaymentHouseService;
import com.wanli.community.service.impl.PaymentHouseServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PaymentHouseHandler {
    PaymentHouseService service = new PaymentHouseServiceImpl();

    public Result listByHouseId(HttpServletRequest request) {
        Integer houseId = Integer.valueOf(request.getParameter("houseId"));
        List<PaymentHouse> list = service.listByHouseId(houseId);

        if (list != null) {
            return Result.success(20000, "房屋缴费信息请求成功", list);
        } else {
            return Result.fail("房屋缴费信息请求成功");

        }

    }

    public Result updateState(HttpServletRequest request) {
        Integer paymentHouseId = Integer.valueOf(request.getParameter("paymentHouseId"));

        PaymentHouse paymentHouse = new PaymentHouse();
        paymentHouse.setPaymentHouseId(paymentHouseId);

        if (service.updateState(paymentHouse)){
            return Result.success("房屋缴费信息更新成功");
        } else {
            return Result.fail("房屋缴费信息更新失败");
        }

    }
}
