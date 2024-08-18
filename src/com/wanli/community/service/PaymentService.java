package com.wanli.community.service;

import com.wanli.community.entity.Payment;

import java.util.List;

public interface PaymentService {
    public List<Payment> listByAccountId(String accountId);

    public boolean savePayment(Payment payment);

    public boolean updateState(Payment payment);
}
