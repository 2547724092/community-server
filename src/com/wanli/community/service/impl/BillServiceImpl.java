package com.wanli.community.service.impl;

import com.wanli.community.dao.AccountDao;
import com.wanli.community.dao.BillDao;
import com.wanli.community.dao.PaymentDao;
import com.wanli.community.dao.PaymentHouseDao;
import com.wanli.community.dao.impl.AccountDaoImpl;
import com.wanli.community.dao.impl.BillDaoImpl;
import com.wanli.community.dao.impl.PaymentDaoImpl;
import com.wanli.community.dao.impl.PaymentHouseDaoImpl;
import com.wanli.community.entity.Account;
import com.wanli.community.entity.Bill;
import com.wanli.community.entity.Payment;
import com.wanli.community.entity.PaymentHouse;
import com.wanli.community.service.BillService;

import java.time.LocalDateTime;
import java.util.List;

public class BillServiceImpl implements BillService {
    AccountDao accountDao = new AccountDaoImpl();
    BillDao billDao = new BillDaoImpl();
    PaymentHouseDao paymentHouseDao = new PaymentHouseDaoImpl();

    PaymentDao paymentDao = new PaymentDaoImpl();
    @Override
    public List<Bill> listByAccountId(String accountId) {
        return billDao.selectByAccountId(accountId);
    }

    @Override
    public Integer save(Bill bill) {
        bill.setBillTime(LocalDateTime.now());
        Integer billId = billDao.insert(bill);
        return billId;
    }

    public Integer pay(String accountId, Integer houseId){
        Integer billId = 0;

        // 1.需要缴费的房屋和车位的所有信息
        List<PaymentHouse> paymentHouseList = paymentHouseDao.selectByHouseId(houseId);
        List<Payment> paymentList = paymentDao.selectByAccountId(accountId);

        // 2.计算未支付的总额
        Double houseTotal = 0.0;
        for (PaymentHouse h : paymentHouseList){
            if (h.getState() == 0)
                houseTotal += h.getAmount();
        }

        Double carTotal = 0.0;
        for (Payment c : paymentList){
            if (c.getState() == 0)
                carTotal += c.getAmount();
        }

        // 3.扣除用户的余额
        Account account = accountDao.select(accountId);
        if (account.getMoney() < carTotal+houseTotal){
            return -1; //余额不足
        }
        accountDao.updateMoney(accountId,-(carTotal+houseTotal));


        // 4.更新支付表中是否支付状态
        for (PaymentHouse h : paymentHouseList){
            h.setState(1);
            paymentHouseDao.updateState(h);
        }

        for (Payment c : paymentList){
            c.setState(1);
            paymentDao.updateState(c);
        }


        // 5.将信息录入bill表
        Bill billHouse = new Bill();
        billHouse.setBillType(1);
        billHouse.setBillTime(LocalDateTime.now());
        billHouse.setAccountId(accountId);
        billHouse.setAmount(houseTotal);

        if (houseTotal != 0){
            billId = billDao.insert(billHouse);
        }


        Bill billCar = new Bill();
        billCar.setBillType(0);
        billCar.setBillTime(LocalDateTime.now());
        billCar.setAccountId(accountId);
        billCar.setAmount(carTotal);
        if (carTotal != 0){
            billDao.insert(billCar);
        }

        // 5.返回最后的自增id
        return billId;
    }
}
