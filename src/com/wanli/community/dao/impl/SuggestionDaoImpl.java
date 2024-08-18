package com.wanli.community.dao.impl;

import com.wanli.community.dao.SuggestionDao;
import com.wanli.community.entity.Report;
import com.wanli.community.entity.Suggestion;
import com.wanli.community.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuggestionDaoImpl implements SuggestionDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    @Override
    public int add(Suggestion suggestion) {
        String sql = "INSERT INTO com_suggestion (account_id,suggestion_name,suggestion_content,suggestion_tag,suggestion_time,audit_results,audit_time,state) values (?,?,?,?,?,?,?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,suggestion.getAccountId());
            ps.setString(2,suggestion.getSuggestionName());
            ps.setString(3,suggestion.getSuggestionContent());
            ps.setString(4,suggestion.getSuggestionTag());
            if (suggestion.getSuggestionTime()!=null){
                ps.setTimestamp(5, Timestamp.valueOf(suggestion.getSuggestionTime()));
            }
            ps.setString(6,suggestion.getAuditResults());
            if (suggestion.getAuditTime()!=null){
                ps.setTimestamp(7, Timestamp.valueOf(suggestion.getAuditTime()));
            }else ps.setTimestamp(7,null);
            ps.setInt(8,suggestion.getState());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return 0;
    }

    @Override
    public List<Suggestion> selectSuggestionByAccountId(String accountId) {
        List<Suggestion> list = new ArrayList<>();

        String sql = "SELECT * FROM com_suggestion WHERE account_id=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,accountId);
            rs = ps.executeQuery();

            while (rs.next()){
                Suggestion suggestion = new Suggestion();
                String Id = String.valueOf(rs.getInt("suggestion_id"));
                suggestion.setID(Id);
                suggestion.setSuggestionId(rs.getInt("suggestion_id"));
                suggestion.setAccountId(rs.getString("account_id"));
                suggestion.setSuggestionName(rs.getString("suggestion_name"));
                suggestion.setSuggestionContent(rs.getString("suggestion_content"));
                suggestion.setSuggestionTag(rs.getString("suggestion_tag"));
                if (rs.getTimestamp("suggestion_time")!=null){
                    suggestion.setSuggestionTime(rs.getTimestamp("suggestion_time").toLocalDateTime());
                }else {suggestion.setSuggestionTime(null);}
                suggestion.setAuditResults(rs.getString("audit_results"));
                if (rs.getTimestamp("audit_time")!=null){
                    suggestion.setAuditTime(rs.getTimestamp("audit_time").toLocalDateTime());
                }else {suggestion.setAuditTime(null);}
                suggestion.setState(rs.getInt("state"));

                list.add(suggestion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return list;
    }

    @Override
    public Suggestion selectDetailBySuggestionId(Integer suggestionId) {
        Suggestion suggestionDetail = new Suggestion();
        String sql = "SELECT * FROM com_suggestion WHERE suggestion_id =?";
        try {
            conn=DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,suggestionId);
            rs = ps.executeQuery();

            if (rs.next()){
                String Id = String.valueOf(rs.getInt("suggestion_id"));
                suggestionDetail.setID(Id);
                suggestionDetail.setSuggestionId(rs.getInt("suggestion_id"));
                suggestionDetail.setAccountId(rs.getString("account_id"));
                suggestionDetail.setSuggestionName(rs.getString("suggestion_name"));
                suggestionDetail.setSuggestionContent(rs.getString("suggestion_content"));
                suggestionDetail.setSuggestionTag(rs.getString("suggestion_tag"));
                if (rs.getTimestamp("suggestion_time")!=null){
                    suggestionDetail.setSuggestionTime(rs.getTimestamp("suggestion_time").toLocalDateTime());
                }else {suggestionDetail.setSuggestionTime(null);}
                suggestionDetail.setAuditResults(rs.getString("audit_results"));
                if (rs.getTimestamp("audit_time")!=null){
                    suggestionDetail.setAuditTime(rs.getTimestamp("audit_time").toLocalDateTime());
                }else {suggestionDetail.setAuditTime(null);}
                suggestionDetail.setState(rs.getInt("state"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suggestionDetail;
    }
}
