package com.wanli.community.dao.impl;

import com.wanli.community.dao.CarDao;
import com.wanli.community.dao.ParkingDao;
import com.wanli.community.entity.Car;
import com.wanli.community.entity.Parking;
import com.wanli.community.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkingDaoImpl implements ParkingDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Statement st = null;


    @Override
    public Parking select(Integer parkingId) {
        String sql = "SELECT * FROM com_parking WHERE parking_id = ?";
        Parking parking = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, parkingId);
            rs = ps.executeQuery();

            if (rs.next()) {
                parking = new Parking();
                parking.setParkingId(rs.getInt("parking_id"));
                parking.setState(rs.getInt("state"));
                parking.setParkingArea(rs.getString("parking_area"));
                parking.setParkingNumber(rs.getInt("parking_number"));

            }
            return parking;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return null;
    }

    @Override
    public List<Parking> select() {
        String sql = "SELECT * FROM com_parking";
        List<Parking> list = new ArrayList<>();

        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()){
                Parking parking = new Parking();
                parking.setParkingId(rs.getInt("parking_id"));
                parking.setParkingArea(rs.getString("parking_area"));
                parking.setParkingNumber(rs.getInt("parking_number"));
                parking.setState(rs.getInt("state"));
                list.add(parking);
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
    public Integer update(Parking parking) {
        String sql = "UPDATE com_parking SET parking_area=?, parking_number=?, state = ? WHERE parking_id =?";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, parking.getParkingArea());
            ps.setInt(2, parking.getParkingNumber());
            ps.setInt(3, parking.getState());
            ps.setInt(4, parking.getParkingId());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return 0;
    }

    @Override
    public Integer updateState(Parking parking) {
        String sql = "UPDATE com_parking SET state = ? WHERE parking_id =?";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, parking.getState());
            ps.setInt(2, parking.getParkingId());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return 0;
    }


}
