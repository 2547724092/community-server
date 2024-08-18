package com.wanli.community.dao.impl;

import com.wanli.community.dao.HouseDao;
import com.wanli.community.entity.House;
import com.wanli.community.entity.Parking;
import com.wanli.community.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseDaoImpl implements HouseDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public List<House> select() {
        String sql = "SELECT * FROM com_house";
        List<House> list = new ArrayList<>();
        House house = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                house = new House();
                house.setHouseId(rs.getInt("house_id"));
                house.setHouseAddress(rs.getString("house_address"));

                list.add(house);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return null;
    }

    @Override
    public House select(Integer houseId) {
        String sql = "SELECT * FROM com_house WHERE house_id = ?";
        House house = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, houseId);
            rs = ps.executeQuery();

            if (rs.next()) {
                house = new House();
                house.setHouseId(rs.getInt("house_id"));
                house.setHouseAddress(rs.getString("house_address"));
            }
            return house;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return null;
    }

}
