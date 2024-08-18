package com.wanli.community.service.impl;

import com.wanli.community.dao.PaymentDao;
import com.wanli.community.dao.impl.PaymentDaoImpl;
import com.wanli.community.entity.Payment;
import com.wanli.community.service.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    PaymentDao dao = new PaymentDaoImpl();
    @Override
    public List<Payment> listByAccountId(String accountId) {
        return dao.selectByAccountId(accountId);
    }

    @Override
    public boolean savePayment(Payment payment) {
        return dao.insertPayment(payment) > 0;
    }

    @Override
    public boolean updateState(Payment payment) {
        payment.setState(1);
        return dao.updateState(payment) > 0;
    }
}
