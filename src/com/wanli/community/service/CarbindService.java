package com.wanli.community.service;

import com.wanli.community.entity.Car;
import com.wanli.community.entity.Carbind;

import java.util.List;

public interface CarbindService {
    public List<Carbind> listCarbindByAccountId(String accountId);

    public Carbind getCarbindByCarbindId(Integer carbindId);

    public Integer save(Carbind carbind);

    public boolean del(Carbind carbind);
}
