package com.wanli.community.dao.impl;

import com.wanli.community.dao.CarbindDao;
import com.wanli.community.dao.ParkingDao;
import com.wanli.community.dao.PaymentDao;
import com.wanli.community.entity.Carbind;
import com.wanli.community.entity.Payment;
import com.wanli.community.util.DBUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private CarbindDao carbindDao = new CarbindDaoImpl();


    @Override
    public List<Payment> selectByAccountId(String accountId) {
        List<Payment> list = new ArrayList<>();
        Payment payment = null;
        String sql = "SELECT * FROM com_payment WHERE account_id = ?";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountId);
            rs = ps.executeQuery();

            while (rs.next()){
                payment = new Payment();
                payment.setPaymentId(rs.getInt("payment_id"));
                payment.setAccountId(rs.getString("account_id"));
                payment.setPaymentType(rs.getInt("payment_type"));
                payment.setRelatedId(rs.getInt("related_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setState(rs.getInt("state"));
                payment.setPaymentTime(rs.getTimestamp("payment_time").toLocalDateTime());

                if (rs.getInt("payment_type") == 0){
                    Carbind carbind = carbindDao.select(rs.getInt("related_id"));
                    payment.setCarbind(carbind);
                }else {
                    System.out.println("设置House");
                }

                list.add(payment);
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
    public Integer insertPayment(Payment payment) {
        String sql = "INSERT INTO com_payment (payment_id, account_id, payment_type, related_id, amount, state, payment_time)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, null);
            ps.setString(2, payment.getAccountId());
            ps.setInt(3,payment.getPaymentType());
            ps.setInt(4,payment.getRelatedId());
            ps.setDouble(5, payment.getAmount());
            ps.setInt(6,payment.getState());
            ps.setTimestamp(7, Timestamp.valueOf(payment.getPaymentTime()));

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }


        return null;
    }

    @Override
    public Integer update(Payment payment) {
        String sql = "UPDATE com_payment SET account_id = ?, payment_type = ?, related_id = ?, amount = ?, state = ?, payment_time = ? WHERE payment_id = ?;";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, payment.getAccountId());
            ps.setInt(2,payment.getPaymentType());
            ps.setInt(3,payment.getRelatedId());
            ps.setDouble(4, payment.getAmount());
            ps.setInt(5,payment.getState());
            ps.setTimestamp(6, Timestamp.valueOf(payment.getPaymentTime()));

            ps.setInt(7, payment.getPaymentId());


            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return null;
    }

    public Integer updateState(Payment payment){
        String sql = "UPDATE com_payment SET state = ? WHERE payment_id = ?;";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);


            ps.setInt(1,payment.getState());
            ps.setInt(2, payment.getPaymentId());


            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return null;
    }
}
