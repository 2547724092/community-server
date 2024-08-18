package com.wanli.community.dao.impl;

import com.wanli.community.dao.HouseDao;
import com.wanli.community.dao.HousebindDao;
import com.wanli.community.entity.House;
import com.wanli.community.entity.Housebind;
import com.wanli.community.util.DBUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HousebindDaoImpl implements HousebindDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    HouseDao houseDao = new HouseDaoImpl();
    @Override
    public Housebind selectByHousebindId(Integer housebindId) {
        String sql = "SELECT * FROM com_housebind WHERE housebind_id = ?";
        Housebind housebind = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, housebindId);
            rs = ps.executeQuery();

            if (rs.next()) {
                housebind = new Housebind();

                housebind.setHousebindId(rs.getInt("housebind_id"));
                housebind.setHouseId(rs.getInt("house_id"));
                housebind.setAccountId(rs.getString("account_id"));
                housebind.setCreated(rs.getTimestamp("created").toLocalDateTime());
                housebind.setUpdated(rs.getTimestamp("updated").toLocalDateTime());

//                House house = houseDao.select(rs.getInt("house_id"));
//                housebind.setHouse(house);

            }
            return housebind;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return null;
    }
    @Override
    public Housebind selectByAccountId(String accountId) {
        String sql = "SELECT * FROM com_housebind WHERE account_id = ?";
        Housebind housebind = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountId);
            rs = ps.executeQuery();

            if (rs.next()) {
                housebind = new Housebind();

                housebind.setHousebindId(rs.getInt("housebind_id"));
                housebind.setHouseId(rs.getInt("house_id"));
                housebind.setAccountId(rs.getString("account_id"));
                housebind.setCreated(rs.getTimestamp("created").toLocalDateTime());
                housebind.setUpdated(rs.getTimestamp("updated").toLocalDateTime());

                House house = houseDao.select(rs.getInt("house_id"));
                housebind.setHouse(house);

            }
            return housebind;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return null;
    }

    public List<Housebind> selectByHouseId(Integer houseId){
        String sql = "SELECT * FROM com_housebind WHERE house_id = ?";
        List<Housebind> list = new ArrayList<>();
        Housebind housebind = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, houseId);
            rs = ps.executeQuery();

            while (rs.next()) {
                housebind = new Housebind();

                housebind.setHousebindId(rs.getInt("housebind_id"));
                housebind.setHouseId(rs.getInt("house_id"));
                housebind.setAccountId(rs.getString("account_id"));
                housebind.setCreated(rs.getTimestamp("created").toLocalDateTime());
                housebind.setUpdated(rs.getTimestamp("updated").toLocalDateTime());

                House house = houseDao.select(rs.getInt("house_id"));
                housebind.setHouse(house);
                list.add(housebind);

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
    public Integer insert(Housebind housebind) {
        Integer housebindId = 0;
        String sql = "INSERT INTO com_housebind (housebind_id, house_id, account_id, created, updated) VALUES (?, ?, ?, ?, ?)";

        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setInt(2, housebind.getHouseId());
            ps.setString(3, housebind.getAccountId());
            ps.setTimestamp(4, Timestamp.valueOf(housebind.getCreated()));
            ps.setTimestamp(5, Timestamp.valueOf(housebind.getUpdated()));

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                housebindId = rs.getInt(1);
            }
            return housebindId;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return null;
    }

    @Override
    public Integer update(Housebind housebind) {
        String sql = "UPDATE com_housebind SET house_id = ?, updated = ? WHERE housebind_id = ?";
        try {
            conn = DBUtil.getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, housebind.getHouseId());
            ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(3, housebind.getHousebindId());

           return  ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return 0;
    }

}
