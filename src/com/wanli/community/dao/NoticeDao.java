package com.wanli.community.dao;

import com.wanli.community.entity.Notice;
import com.wanli.community.entity.NoticeState;

import java.util.List;

public interface NoticeDao {
    public List<Notice> selectNoticeByNoticeId(Integer noticeId);

    public List<Notice> selectNoticeWithState(String accountId);

    public Notice selectNoticeWithStateById(String accountId, Integer noticeId);

    // 更新公告点击数
    public void updateNoticeClicks(Integer noticeId);

    public int updateNoticeLikes(Integer noticeId, Integer value);

}
