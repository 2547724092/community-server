package com.wanli.community.dao;

import com.wanli.community.entity.Payment;

import java.util.List;

public interface PaymentDao {
    public List<Payment> selectByAccountId(String accountId);

    public Integer insertPayment(Payment payment);

    public Integer update(Payment payment);
    public Integer updateState(Payment payment);
}
