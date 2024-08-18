package com.wanli.community.dao.impl;

import com.wanli.community.dao.ReportDao;
import com.wanli.community.entity.Report;
import com.wanli.community.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDaoImpl implements ReportDao{
    //读取数据库
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    @Override
    public List<Report> selectByAccountId(String accountId) {
        List<Report> list = new ArrayList<>();

        String sql = "SELECT * FROM com_report WHERE account_id=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,accountId);
            rs = ps.executeQuery();

            while (rs.next()){
                Report report = new Report();
                report.setReportId(rs.getInt("report_id"));
                report.setReportTime(rs.getString("report_time"));
                report.setAccountId(rs.getString("account_id"));
                report.setReportName(rs.getString("report_name"));
                report.setReportType(rs.getString("report_type"));
                report.setReportContent(rs.getString("report_content"));
                report.setReportImg(rs.getString("report_img"));
                report.setReportAddress(rs.getString("report_address"));
                if (rs.getTimestamp("report_submit")!=null){
                    report.setReportSubmit(rs.getTimestamp("report_submit").toLocalDateTime());
                }
                report.setAuditResults(rs.getString("audit_results"));
                report.setReviewer(rs.getString("reviewer"));
                if (rs.getTimestamp("audit_time")!=null){
                    report.setAuditTime(rs.getTimestamp("audit_time").toLocalDateTime());
                }else {report.setAuditTime(null);}
                report.setState(rs.getInt("state"));

                list.add(report);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return list;
    }

    @Override
    public Report selectReportDetailOne(Integer reportId) {
        Report report = new Report();
        String sql = "SELECT * FROM com_report WHERE report_id =?";
        try {
            conn=DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,reportId);
            rs = ps.executeQuery();

            if (rs.next()){
                report.setReportId(rs.getInt("report_id"));
                report.setReportTime(rs.getString("report_time"));
                report.setAccountId(rs.getString("account_id"));
                report.setReportName(rs.getString("report_name"));
                report.setReportType(rs.getString("report_type"));
                report.setReportContent(rs.getString("report_content"));
                report.setReportImg(rs.getString("report_img"));
                report.setReportAddress(rs.getString("report_address"));
                if (rs.getTimestamp("report_submit")!=null){
                    report.setReportSubmit(rs.getTimestamp("report_submit").toLocalDateTime());
                }
                report.setAuditResults(rs.getString("audit_results"));
                report.setReviewer(rs.getString("reviewer"));
                if (rs.getTimestamp("audit_time")!=null){
                    report.setAuditTime(rs.getTimestamp("audit_time").toLocalDateTime());
                }else {report.setAuditTime(null);}
                report.setState(rs.getInt("state"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return report;
    }

    @Override
    public int add(Report report) {
        String sql = "INSERT INTO com_report (report_time,account_id,report_name,report_type,report_content,report_img,report_address,report_submit,audit_results,reviewer,audit_time,state) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,report.getReportTime());
            ps.setString(2,report.getAccountId());
            ps.setString(3,report.getReportName());
            ps.setString(4, report.getReportType());
            ps.setString(5,report.getReportContent());
            ps.setString(6,report.getReportImg());
            ps.setString(7,report.getReportAddress());
            if (report.getReportSubmit()!=null){
                ps.setTimestamp(8, Timestamp.valueOf(report.getReportSubmit()));
            }
            ps.setString(9,report.getAuditResults());
            ps.setString(10,report.getReviewer());
            if (report.getAuditTime()!=null){
                ps.setTimestamp(11,Timestamp.valueOf(report.getAuditTime()));
            }else {ps.setTimestamp(11,null);}

            ps.setInt(12,report.getState());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return 0;
    }
}
