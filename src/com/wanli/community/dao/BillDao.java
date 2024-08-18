package com.wanli.community.dao;

import com.wanli.community.entity.Bill;

import java.util.List;

public interface BillDao {

    public List<Bill> selectByAccountId(String accountId);

    public Integer insert(Bill bill);
}
