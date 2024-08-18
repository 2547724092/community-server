package com.wanli.community.dao.impl;

import com.wanli.community.dao.CarDao;
import com.wanli.community.entity.Car;
import com.wanli.community.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public List<Car> selectCarByAccountId(String accountId) {
        List<Car> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM com_car WHERE account_id = ?";

            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountId);
            rs = ps.executeQuery();


            while (rs.next()){
                Car car = new Car();

                car.setCarId(rs.getInt("car_id"));
                car.setCarLicense(rs.getString("car_license"));
                car.setCarImg(rs.getString("car_img"));
                car.setAccountId(rs.getString("account_id"));
                car.setCarType(rs.getString("car_type"));

                list.add(car);
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
    public Car selectCarByCarId(Integer carId) {
        Car car = null;

        try {
            String sql = "SELECT * FROM com_car WHERE car_id = ?";

            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, carId);
            rs = ps.executeQuery();


           if (rs.next()){
                car = new Car();

                car.setCarId(rs.getInt("car_id"));
                car.setCarLicense(rs.getString("car_license"));
                car.setCarImg(rs.getString("car_img"));
                car.setAccountId(rs.getString("account_id"));
                car.setCarType(rs.getString("car_type"));
            }
            return car;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return null;
    }

    @Override
    public Integer insert(Car car) {
        String sql = "INSERT INTO com_car(car_license, car_img, account_id, car_type) VALUES(?, ?, ?, ?)";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, car.getCarLicense());
            ps.setString(2, car.getCarImg());
            ps.setString(3, car.getAccountId());
            ps.setString(4, car.getCarType());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return 0;
    }


}
