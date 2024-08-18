package com.wanli.community.dao.impl;

import com.wanli.community.dao.HousebindDao;
import com.wanli.community.dao.PaymentHouseDao;
import com.wanli.community.entity.Housebind;
import com.wanli.community.entity.Payment;
import com.wanli.community.entity.PaymentHouse;
import com.wanli.community.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentHouseDaoImpl implements PaymentHouseDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    HousebindDao housebindDao = new HousebindDaoImpl();

    @Override
    public List<PaymentHouse> selectByHouseId(Integer houseId) {
        List<PaymentHouse> list = new ArrayList<>();
        PaymentHouse paymentHouse = null;
        String sql = "SELECT * FROM com_payment_house WHERE house_id = ? AND state != 1";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, houseId);
            rs =  ps.executeQuery();

            while (rs.next()){
                paymentHouse = new PaymentHouse();
                paymentHouse.setPaymentHouseId(rs.getInt("payment_house_id"));
                paymentHouse.setHouseId(rs.getInt("house_id"));
                paymentHouse.setAmount(rs.getDouble("amount"));
                paymentHouse.setState(rs.getInt("state"));
                paymentHouse.setAmountType(rs.getInt("amount_type"));
                paymentHouse.setPaymentTime(rs.getTimestamp("payment_time").toLocalDateTime());


                Housebind housebind = housebindDao.selectByHousebindId(rs.getInt("house_id"));
                paymentHouse.setHousebind(housebind);


                list.add(paymentHouse);
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
    public Integer updateState(PaymentHouse paymentHouse) {
        String sql = "UPDATE com_payment_house SET state = ? WHERE payment_house_id = ?;";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1,paymentHouse.getState());
            ps.setInt(2, paymentHouse.getPaymentHouseId());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return null;
    }
}
