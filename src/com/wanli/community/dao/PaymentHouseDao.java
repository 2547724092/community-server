package com.wanli.community.dao;

import com.wanli.community.entity.Payment;
import com.wanli.community.entity.PaymentHouse;

import java.util.List;

public interface PaymentHouseDao {
    public List<PaymentHouse> selectByHouseId(Integer houseId);
    public Integer updateState(PaymentHouse paymentHouse);
}
