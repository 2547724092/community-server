package com.wanli.community.dao;

import com.wanli.community.entity.Carbind;

import java.util.List;

public interface CarbindDao {
    public List<Carbind> selectCarbind();
    public List<Carbind> select(String accountId);

    public Carbind select(Integer carbindId);

    public Integer insert(Carbind carbind);

    public Integer del(Carbind carbind);
}
