package com.wanli.community.service.impl;

import com.wanli.community.dao.HouseDao;
import com.wanli.community.dao.impl.HouseDaoImpl;
import com.wanli.community.entity.House;
import com.wanli.community.service.HouseService;

import java.util.List;

public class HouseServiceImpl implements HouseService {
    HouseDao dao = new HouseDaoImpl();
    @Override
    public List<House> listHouse() {
        return dao.select();
    }

    @Override
    public House lisByHouseId(Integer houseId) {
        return dao.select(houseId);
    }
}
