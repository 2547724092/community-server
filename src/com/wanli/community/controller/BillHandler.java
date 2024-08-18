package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.Bill;
import com.wanli.community.service.BillService;
import com.wanli.community.service.impl.BillServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class BillHandler {
    BillService service = new BillServiceImpl();

    public Result listByAccountId(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");

        List<Bill> list = service.listByAccountId(accountId);

        if (list != null) {
            return Result.success(20000, "账单信息请求成功", list);
        } else {
            return Result.fail("账单信息请求失败");
        }

    }

    public Result save(HttpServletRequest request) {
        Bill bill = new Bill();
        Integer billId = 0;

        String accountId = request.getParameter("accountId");
        Double amount = Double.valueOf(request.getParameter("amount"));
        Integer bill_type = Integer.valueOf(request.getParameter("billType"));

        bill.setAccountId(accountId);
        bill.setAmount(amount);
        bill.setBillType(bill_type);


        billId = service.save(bill);
        if (billId != null) {
            return Result.success("账单信息保存成功");
        } else {
            return Result.fail("账单信息保存失败");
        }
    }

    public Result pay(HttpServletRequest request){
        Integer billCode = 0;

        // 获得所需id
        String accountId = request.getParameter("accountId");
        Integer houseId = 0;
        if (request.getParameter("houseId") != null && request.getParameter("houseId") != ""){
            houseId = Integer.valueOf(request.getParameter("houseId"));
        }

        billCode = service.pay(accountId, houseId);
        if (billCode == -1){
            return Result.fail("用户余额不足");
        } else if (billCode == null) {
            return Result.fail("录入信息出错, 账单支付失败");
        } else {
            return Result.success("账单支付成功");
        }
    }
}
