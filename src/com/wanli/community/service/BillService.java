package com.wanli.community.service;

import com.wanli.community.entity.Bill;

import java.util.List;

public interface BillService {

    public List<Bill> listByAccountId(String accountId);

    public Integer save(Bill bill);

    public Integer pay(String accountId, Integer houseId);
}
