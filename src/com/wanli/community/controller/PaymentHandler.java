package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.Payment;
import com.wanli.community.service.PaymentService;
import com.wanli.community.service.impl.PaymentServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class PaymentHandler {
    private PaymentService service = new PaymentServiceImpl();

    public Result listByAccountId(HttpServletRequest request){
        String accountId = request.getParameter("accountId");
        List<Payment> list = service.listByAccountId(accountId);

        if (list != null) {
            return Result.success(20000,"缴费信息请求成功", list);
        }else {
            return Result.fail("缴费信息请求成功");
        }
    }

    public Result savePayment(HttpServletRequest request){
        String accountId = request.getParameter("accountId");
        Integer paymentType = Integer.valueOf(request.getParameter("paymentType"));
        Integer relatedId = Integer.valueOf(request.getParameter("relatedId"));
        Double amount = Double.valueOf(request.getParameter("amount"));
        Timestamp paymentTime = Timestamp.valueOf(request.getParameter("paymentTime"));

        Payment payment = new Payment();
        payment.setAccountId(accountId);
        payment.setPaymentType(paymentType);
        payment.setRelatedId(relatedId);
        payment.setAmount(amount);
        payment.setPaymentTime(paymentTime.toLocalDateTime());

        if (service.savePayment(payment)){
            return Result.success("缴费信息保存成功");
        } else {
            return Result.fail("缴费信息保存失败");
        }
    }

    public Result updateState(HttpServletRequest request){
        Integer paymentId = Integer.valueOf(request.getParameter("paymentId"));

        Payment payment = new Payment();
        payment.setPaymentId(paymentId);

        if (service.updateState(payment)){
            return Result.success("车辆缴费信息更新成功");
        } else {
            return Result.fail("车辆缴费信息更新失败");
        }
    }
}
