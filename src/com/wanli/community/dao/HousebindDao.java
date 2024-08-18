package com.wanli.community.dao;

import com.wanli.community.entity.House;
import com.wanli.community.entity.Housebind;

import java.util.List;

public interface HousebindDao {
    public Housebind selectByHousebindId(Integer housebindId);

    public List<Housebind> selectByHouseId(Integer houseId);

    public Housebind selectByAccountId(String accountId);
    public Integer insert(Housebind housebind);

    public Integer update(Housebind housebind);
}
