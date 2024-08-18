package com.wanli.community.service;

import com.wanli.community.entity.Housebind;

import java.util.List;

public interface HousebindService {
    public Housebind listByHousebindId(Integer houseId);

    public List<Housebind> listByHouseId(Integer houseId);

    public Housebind listByAccountId(String accountId);

    public Integer save(Housebind housebind);

    public boolean update(Housebind housebind);
}
