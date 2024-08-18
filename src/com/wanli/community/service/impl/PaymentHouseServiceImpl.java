package com.wanli.community.service.impl;

import com.wanli.community.dao.PaymentHouseDao;
import com.wanli.community.dao.impl.PaymentHouseDaoImpl;
import com.wanli.community.entity.PaymentHouse;
import com.wanli.community.service.PaymentHouseService;

import java.util.List;

public class PaymentHouseServiceImpl implements PaymentHouseService {
    PaymentHouseDao dao = new PaymentHouseDaoImpl();
    @Override
    public List<PaymentHouse> listByHouseId(Integer houseId) {
        return dao.selectByHouseId(houseId);
    }

    @Override
    public boolean updateState(PaymentHouse paymentHouse) {
        paymentHouse.setState(1);
        return dao.updateState(paymentHouse) > 0;
    }
}
