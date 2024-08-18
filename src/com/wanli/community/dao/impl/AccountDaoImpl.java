package com.wanli.community.dao.impl;

import com.wanli.community.dao.AccountDao;
import com.wanli.community.dao.HousebindDao;
import com.wanli.community.entity.Account;
import com.wanli.community.entity.Housebind;
import com.wanli.community.util.DBUtil;

import java.sql.*;
import java.time.LocalDateTime;

public class AccountDaoImpl implements AccountDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private HousebindDao housebindDao = new HousebindDaoImpl();

    @Override
    public Account select(String accountId) {
        String sql = "SELECT * FROM com_account WHERE account_id = ?";
        Account account = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountId);
            rs = ps.executeQuery();

            if (rs.next()) {
                account = new Account();
                account.setAccountId(rs.getString("account_id"));
                account.setPassword(rs.getString("password"));
                account.setAccountName(rs.getString("account_name"));
                account.setAccountSex(rs.getInt("account_sex"));
                account.setAccountImg(rs.getString("account_img"));


                if (rs.getTimestamp("created") != null) {
                    account.setCreated(rs.getTimestamp("created").toLocalDateTime());
                }

                if (rs.getTimestamp("updated") != null) {
                    account.setUpdated(rs.getTimestamp("updated").toLocalDateTime());

                }

                account.setState(rs.getInt("state"));
                account.setDel_tag(rs.getInt("del_tag"));
                account.setMoney(rs.getDouble("money"));


//                Housebind housebind = housebindDao.selectByAccountId(rs.getString("account_id"));
//                account.setHousebind(housebind);
            }
            return account;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return null;
    }

    @Override
    public Integer insert(Account account) {
        String sql = "INSERT INTO com_account VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getAccountId());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getAccountName());
            ps.setInt(4, account.getAccountSex());
            ps.setString(5, account.getAccountImg());
            ps.setTimestamp(6, Timestamp.valueOf(account.getCreated()));
            ps.setTimestamp(7, Timestamp.valueOf(account.getUpdated()));
            ps.setInt(8, account.getState());
            ps.setInt(9, account.getDel_tag());
            ps.setDouble(10, account.getMoney());

            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtil.close(conn);
        }
        return 0;
    }

    @Override
    public Integer update(Account account) {
        String sql = "UPDATE com_account SET account_name = ?, account_sex = ?, account_img = ?, updated =? WHERE account_id = ?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, account.getAccountName());
            ps.setInt(2, account.getAccountSex());
            ps.setString(3, account.getAccountImg());
            ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            ps.setString(5, account.getAccountId());

            return ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return 0;
    }

    @Override
    public Integer updatePassword(Account account) {
        try {
            String sql = "UPDATE com_account SET password = ?, account_name = ?, account_sex = ?, account_img = ?, updated =? WHERE account_id = ?";

            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

//                ps.setString(1, account.getPassword());
            ps.setString(1, account.getPassword());
            ps.setString(2, account.getAccountName());
            ps.setInt(3, account.getAccountSex());
            ps.setString(4, account.getAccountImg());
            ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            ps.setString(6, account.getAccountId());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return 0;
    }


    @Override
    public Integer updateMoney(String accountId, Double money) {
        String sql = "UPDATE com_account SET money = money + ? WHERE account_id = ?";

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setDouble(1, money);
            ps.setString(2, accountId);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return 0;
    }

    @Override
    public Integer deleteAccount(Account account) {
        String sql = "DELETE FROM com_account WHERE account_id = ?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,account.getAccountId());

            int i = ps.executeUpdate();
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return 0;
    }
}
