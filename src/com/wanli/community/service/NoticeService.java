package com.wanli.community.service;

import com.wanli.community.entity.Notice;
import com.wanli.community.entity.NoticeState;

import java.util.List;

public interface NoticeService {
    public List<Notice> listNoticeByNoticeId(Integer noticeId);

    public List<Notice> listNoticeWithState(String accountId);
    public Notice listNoticeWithStateById(String accountId,Integer noticeId);

    // 处理公告点击事件
    public void handleNoticeClick(Integer noticeId);

    public boolean handleNoticeLikes(Integer noticeId, Integer value);
}
