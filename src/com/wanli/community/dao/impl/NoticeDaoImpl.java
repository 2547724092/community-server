package com.wanli.community.dao.impl;

import com.mysql.cj.xdevapi.DbDoc;
import com.wanli.community.dao.NoticeDao;
import com.wanli.community.dao.NoticeStateDao;
import com.wanli.community.entity.Notice;
import com.wanli.community.entity.NoticeState;
import com.wanli.community.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoticeDaoImpl implements NoticeDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private NoticeStateDao noticeStateDao = new NoticeStateDaoImpl();

    @Override
    public List<Notice> selectNoticeByNoticeId(Integer noticeId) {
        List<Notice> list = new ArrayList<>();
        String sql = null;

        try {
            if (noticeId == 0) {
                sql = "SELECT * FROM com_notice ORDER BY created DESC";
                conn = DBUtil.getConnection();
                ps = conn.prepareStatement(sql);
            } else {
                sql = "SELECT * FROM com_notice WHERE notice_id = ? ORDER BY created DESC";
                conn = DBUtil.getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, noticeId);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                Notice notice = new Notice();
                notice.setNoticeId(rs.getInt("notice_id"));
                notice.setNoticeTitle(rs.getString("notice_title"));
                notice.setNoticeText(rs.getString("notice_text"));
                notice.setNoticeImg(rs.getString("notice_img"));
                notice.setNoticeType(rs.getString("notice_type"));
                notice.setNoticeClicks(rs.getInt("notice_clicks"));
                notice.setNoticeLikes(rs.getInt("notice_likes"));
                if (rs.getTimestamp("created") != null) {
                    notice.setCreated(rs.getTimestamp("created").toLocalDateTime());
                }

                list.add(notice);
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
    public List<Notice> selectNoticeWithState(String accountId) {
        List<Notice> list = new ArrayList<>();
        String sql = "SELECT * FROM com_notice ORDER BY created DESC";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Notice notice = new Notice();
                notice.setNoticeId(rs.getInt("notice_id"));
                notice.setNoticeTitle(rs.getString("notice_title"));
                notice.setNoticeText(rs.getString("notice_text"));
                notice.setNoticeImg(rs.getString("notice_img"));
                notice.setNoticeType(rs.getString("notice_type"));
                notice.setNoticeClicks(rs.getInt("notice_clicks"));
                notice.setNoticeLikes(rs.getInt("notice_likes"));
                if (rs.getTimestamp("created") != null) {
                    notice.setCreated(rs.getTimestamp("created").toLocalDateTime());
                }

                NoticeState noticeState = noticeStateDao.select(accountId, rs.getInt("notice_id"));
                notice.setNoticeState(noticeState);

                list.add(notice);
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
    public Notice selectNoticeWithStateById(String accountId, Integer noticeId) {
        Notice notice = null;
        String sql = "SELECT * FROM com_notice WHERE notice_id = ?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, noticeId);

            rs = ps.executeQuery();

            if (rs.next()) {
                notice = new Notice();
                notice.setNoticeId(rs.getInt("notice_id"));
                notice.setNoticeTitle(rs.getString("notice_title"));
                notice.setNoticeText(rs.getString("notice_text"));
                notice.setNoticeImg(rs.getString("notice_img"));
                notice.setNoticeType(rs.getString("notice_type"));
                notice.setNoticeClicks(rs.getInt("notice_clicks"));
                notice.setNoticeLikes(rs.getInt("notice_likes"));
                if (rs.getTimestamp("created") != null) {
                    notice.setCreated(rs.getTimestamp("created").toLocalDateTime());
                }

                NoticeState noticeState = noticeStateDao.select(accountId, rs.getInt("notice_id"));
                notice.setNoticeState(noticeState);
            }
            return notice;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return null;
    }
    @Override
    public void updateNoticeClicks(Integer noticeId) {
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE com_notice SET notice_clicks = notice_clicks + 1 WHERE notice_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, noticeId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
    }

    @Override
    public int updateNoticeLikes(Integer noticeId, Integer value){
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE com_notice SET notice_likes = notice_likes + ? WHERE notice_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, value);
            ps.setInt(2, noticeId);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return 0;
    }
}

