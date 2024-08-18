package com.wanli.community.dao.impl;

import com.wanli.community.dao.VisitorDao;
import com.wanli.community.entity.Visitor;
import com.wanli.community.service.VisitorService;
import com.wanli.community.util.DBUtil;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VisitorDaoImpl implements VisitorDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public List<Visitor> selectVisitor(String accountId) {
        List<Visitor> list = new ArrayList<>();
        String sql = "SELECT * FROM com_visitor WHERE account_id = ?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Visitor visitor = new Visitor();
                visitor.setVisitorId(rs.getInt("visitor_id"));
                visitor.setVisitorName(rs.getString("visitor_name"));
                visitor.setAccountId(rs.getString("account_id"));
                visitor.setVisitorCome(rs.getTimestamp("visitor_come").toLocalDateTime());
                visitor.setVisitorGo(rs.getTimestamp("visitor_go").toLocalDateTime());
                visitor.setVisitorReason(rs.getString("visitor_reason"));
                visitor.setVisitorImg(rs.getString("visitor_img"));

                visitor.setVisitorSubmit(rs.getTimestamp("visitor_submit").toLocalDateTime());
                visitor.setAuditResults(rs.getString("audit_results"));
                visitor.setReviewer(rs.getString("reviewer"));

                visitor.setState(rs.getInt("state"));

                list.add(visitor);
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
    public List<Visitor> selectVisitorDetails(Integer visitorId) {
        List<Visitor> list = new ArrayList<>();
        String sql = "SELECT * FROM com_visitor WHERE visitor_id = ?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, visitorId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Visitor visitor = new Visitor();
                visitor.setVisitorId(rs.getInt("visitor_id"));
                visitor.setVisitorName(rs.getString("visitor_name"));
                visitor.setAccountId(rs.getString("account_id"));
                visitor.setVisitorCome(rs.getTimestamp("visitor_come").toLocalDateTime());
                visitor.setVisitorGo(rs.getTimestamp("visitor_go").toLocalDateTime());
                visitor.setVisitorReason(rs.getString("visitor_reason"));
                visitor.setVisitorImg(rs.getString("visitor_img"));

                visitor.setVisitorSubmit(rs.getTimestamp("visitor_submit").toLocalDateTime());
                visitor.setAuditResults(rs.getString("audit_results"));
                visitor.setReviewer(rs.getString("reviewer"));
                if (rs.getTimestamp("audit_date") != null){
                    visitor.setAuditDate(rs.getTimestamp("audit_date").toLocalDateTime());
                }
                visitor.setState(rs.getInt("state"));

                list.add(visitor);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return null;
    }

    //新增访客记录到数据库
    @Override
    public int saveVisitor(Visitor visitor) {
        String sql = "INSERT INTO com_visitor (visitor_name,account_id,visitor_come ,visitor_go,visitor_reason,visitor_img,visitor_submit,state) VALUES (?,?,?,?,?,?,?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, visitor.getVisitorName());
            ps.setString(2, visitor.getAccountId());
            ps.setTimestamp(3, Timestamp.valueOf(visitor.getVisitorCome()));
            ps.setTimestamp(4, Timestamp.valueOf(visitor.getVisitorGo()));
            ps.setString(5, visitor.getVisitorReason());
            ps.setString(6, visitor.getVisitorImg());
            ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(8, 2);

            int i = ps.executeUpdate();
            return i;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return 0;
    }

}
