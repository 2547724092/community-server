package com.wanli.community.service;

import com.wanli.community.entity.PaymentHouse;

import java.util.List;

public interface PaymentHouseService {
    public List<PaymentHouse> listByHouseId(Integer houseId);

    public boolean updateState(PaymentHouse paymentHouse);
}
