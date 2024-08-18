package com.wanli.community.service.impl;

import com.wanli.community.dao.HousebindDao;
import com.wanli.community.dao.impl.HousebindDaoImpl;
import com.wanli.community.entity.House;
import com.wanli.community.entity.Housebind;
import com.wanli.community.service.HousebindService;

import java.time.LocalDateTime;
import java.util.List;

public class HousebindServiceImpl implements HousebindService {
    HousebindDao dao = new HousebindDaoImpl();
    @Override
    public Housebind listByHousebindId(Integer housebindId) {
        return dao.selectByHousebindId(housebindId);
    }

    @Override
    public List<Housebind> listByHouseId(Integer houseId){
        return dao.selectByHouseId(houseId);
    }

    @Override
    public Housebind listByAccountId(String accountId) {
        return dao.selectByAccountId(accountId);
    }


    @Override
    public Integer save(Housebind housebind) {

        housebind.setCreated(LocalDateTime.now());
        housebind.setUpdated(LocalDateTime.now());

        Integer housebindId = dao.insert(housebind);

        return housebindId;
    }

    @Override
    public boolean update(Housebind housebind) {
        return dao.update(housebind) > 0;
    }
}
