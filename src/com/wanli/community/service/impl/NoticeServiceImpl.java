package com.wanli.community.service.impl;

import com.wanli.community.dao.NoticeDao;
import com.wanli.community.dao.impl.NoticeDaoImpl;
import com.wanli.community.entity.Notice;
import com.wanli.community.entity.NoticeState;
import com.wanli.community.service.NoticeService;

import java.util.ArrayList;
import java.util.List;

public class NoticeServiceImpl implements NoticeService {
    private NoticeDao dao = new NoticeDaoImpl();

    @Override
    public List<Notice> listNoticeByNoticeId(Integer noticeId) {
        List<Notice> list = new ArrayList<>();
        list = dao.selectNoticeByNoticeId(noticeId);
        System.out.println(list);
        return list;
    }

    @Override
    public List<Notice> listNoticeWithState(String accountId) {
        return dao.selectNoticeWithState(accountId);
    }

    @Override
    public Notice listNoticeWithStateById(String accountId, Integer noticeId) {
        return dao.selectNoticeWithStateById(accountId, noticeId);
    }

    @Override
    public void handleNoticeClick(Integer noticeId) {
        dao.updateNoticeClicks(noticeId);
    }

    @Override
    public boolean handleNoticeLikes(Integer noticeId, Integer value) {
        return dao.updateNoticeLikes(noticeId, value) > 0;
    }

}
