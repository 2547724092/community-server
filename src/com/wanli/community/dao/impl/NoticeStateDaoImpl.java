package com.wanli.community.dao.impl;

import com.wanli.community.dao.NoticeStateDao;
import com.wanli.community.entity.NoticeState;
import com.wanli.community.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class NoticeStateDaoImpl implements NoticeStateDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public NoticeState select(String accountId, Integer noticeId) {
        NoticeState noticeState = null;

        try {
            String sql = "SELECT * FROM com_noticestate WHERE account_id = ? AND notice_id = ?";

            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountId);
            ps.setInt(2, noticeId);

            rs = ps.executeQuery();

            if (rs.next()) {
                noticeState = new NoticeState();

                noticeState.setReadId(rs.getInt("read_id"));
                noticeState.setAccountId(rs.getString("account_id"));
                noticeState.setNoticeId(rs.getInt("notice_id"));
                noticeState.setState(rs.getInt("state"));
                noticeState.setIsLike(rs.getInt("is_like"));
            }
            return noticeState;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return null;
    }


    @Override
    public int insertState(NoticeState noticeState) {
        Integer readId = 0;
        String sql = "INSERT INTO com_noticestate (notice_id, account_id, state, is_like) VALUES (?, ?, 1, 0)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,noticeState.getNoticeId());
            ps.setString(2,noticeState.getAccountId());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                readId = rs.getInt(1);
            }
            return readId;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return 0;
    }

    @Override
    public int updateIsLike(NoticeState noticeState) {

        String sql = "UPDATE com_noticestate SET is_like = ? WHERE read_id = ?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, noticeState.getState());
            ps.setInt(2, noticeState.getReadId());

            return ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return 0;
    }
}
