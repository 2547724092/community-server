package com.wanli.community.dao.impl;

import com.wanli.community.dao.BillDao;
import com.wanli.community.entity.Bill;
import com.wanli.community.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements BillDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    @Override
    public List<Bill> selectByAccountId(String accountId) {
        List<Bill> list = new ArrayList<>();
        Bill bill = null;

        String sql = "SELECT * FROM com_bill WHERE account_id = ? ORDER BY bill_time DESC";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountId);
            rs = ps.executeQuery();

            while (rs.next()){
                bill = new Bill();
                bill.setBillId(rs.getInt("bill_id"));
                bill.setAccountId(rs.getString("account_id"));
                bill.setAmount(rs.getDouble("amount"));
                bill.setBillTime(rs.getTimestamp("bill_time").toLocalDateTime());
                bill.setBillType(rs.getInt("bill_type"));

                list.add(bill);
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
    public Integer insert(Bill bill) {
        Integer billId = 0;

        String sql = "INSERT INTO com_bill (bill_id, account_id, amount, bill_time, bill_type) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, bill.getAccountId());
            ps.setDouble(3, bill.getAmount());
            ps.setTimestamp(4, Timestamp.valueOf(bill.getBillTime()));
            ps.setInt(5, bill.getBillType());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            if (rs.next()){
                billId = rs.getInt(1);
            }
            return billId;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return null;
    }
}
