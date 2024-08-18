package com.wanli.community.dao.impl;

import com.wanli.community.dao.CarDao;
import com.wanli.community.dao.CarbindDao;
import com.wanli.community.dao.ParkingDao;
import com.wanli.community.entity.Car;
import com.wanli.community.entity.Carbind;
import com.wanli.community.entity.Parking;
import com.wanli.community.util.DBUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarbindDaoImpl implements CarbindDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    private CarDao carDao = new CarDaoImpl();
    private ParkingDao parkingDao = new ParkingDaoImpl();

    @Override
    public List<Carbind> selectCarbind() {
        List<Carbind> list = new ArrayList<>();
        Parking parking = null;

        Carbind carbind = null;

        String sql = "SELECT * FROM com_carbind bind, com_car car WHERE car.car_id = bind.car_id AND bind.del_tag != 0";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                carbind = new Carbind();

                carbind.setCarbindId(rs.getInt("carbind_id"));
                carbind.setParkingId(rs.getInt("parking_id"));
                carbind.setCarId(rs.getInt("car_id"));
                carbind.setCarbindStart(rs.getTimestamp("carbind_start").toLocalDateTime());
                carbind.setCarbindEnd(rs.getTimestamp("carbind_end").toLocalDateTime());
                carbind.setPayment(rs.getDouble("payment"));
                carbind.setReviewerId(rs.getString("reviewer_id"));
                carbind.setState(rs.getInt("state"));

                parking = parkingDao.select(rs.getInt("parking_id"));
                carbind.setParking(parking);

                list.add(carbind);
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
    public List<Carbind> select(String accountId) {
        List<Carbind> list = new ArrayList<>();

        Carbind carbind = null;

        String sql = "SELECT * FROM com_carbind bind, com_car car WHERE car.car_id = bind.car_id AND account_id = ? AND bind.del_tag != 0";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountId);
            rs = ps.executeQuery();

            while (rs.next()) {
                carbind = new Carbind();

                carbind.setCarbindId(rs.getInt("carbind_id"));
                carbind.setParkingId(rs.getInt("parking_id"));
                carbind.setCarId(rs.getInt("car_id"));
                carbind.setCarbindStart(rs.getTimestamp("carbind_start").toLocalDateTime());
                carbind.setCarbindEnd(rs.getTimestamp("carbind_end").toLocalDateTime());
                carbind.setPayment(rs.getDouble("payment"));
                carbind.setReviewerId(rs.getString("reviewer_id"));
                carbind.setState(rs.getInt("state"));


                list.add(carbind);
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
    public Carbind select(Integer carbindId) {
        Carbind carbind = null;

        String sql = "SELECT * FROM com_carbind WHERE carbind_id = ?";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, carbindId);
            rs = ps.executeQuery();

            while (rs.next()) {
                carbind = new Carbind();

                carbind.setCarbindId(rs.getInt("carbind_id"));
                carbind.setParkingId(rs.getInt("parking_id"));
                carbind.setCarId(rs.getInt("car_id"));
                carbind.setCarbindStart(rs.getTimestamp("carbind_start").toLocalDateTime());
                carbind.setCarbindEnd(rs.getTimestamp("carbind_end").toLocalDateTime());
                carbind.setPayment(rs.getDouble("payment"));
                carbind.setReviewerId(rs.getString("reviewer_id"));
                carbind.setState(rs.getInt("state"));

                Car car = carDao.selectCarByCarId(rs.getInt("car_id"));
                Parking parking = parkingDao.select(rs.getInt("parking_id"));

                carbind.setCar(car);
                carbind.setParking(parking);
            }
            return carbind;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return null;
    }

    @Override
    public Integer insert(Carbind carbind) {
        Integer carbindId = 0;
        String sql = "INSERT INTO com_carbind(parking_id,car_id,carbind_start,carbind_end,payment,reviewer_id,state,del_tag) VALUES(?, ?, ?, ?, ?, 1, 2, 1)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, carbind.getParkingId());
            ps.setInt(2, carbind.getCarId());
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            ps.setTimestamp(4, Timestamp.valueOf(carbind.getCarbindEnd()));
            ps.setDouble(5, carbind.getPayment());
//            ps.setString(6,carbind.getReviewerId());
//            ps.setInt(7, carbind.getState());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()){
                carbindId = rs.getInt(1);
            }

            return carbindId;



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return 0;
    }

    @Override
    public Integer del(Carbind carbind) {
//        String sql = "DELETE FROM com_carbind WHERE carbind_id = ?";
        String sql = "UPDATE com_carbind SET del_tag = 0 WHERE carbind_id = ?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, carbind.getCarbindId()); // 使用 carbindId 进行删除操作
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return 0;
    }

}
