package com.wanli.community.service.impl;

import com.wanli.community.dao.NoticeDao;
import com.wanli.community.dao.NoticeStateDao;
import com.wanli.community.dao.impl.NoticeDaoImpl;
import com.wanli.community.dao.impl.NoticeStateDaoImpl;
import com.wanli.community.entity.NoticeState;
import com.wanli.community.service.NoticeStateService;

import java.util.List;

public class NoticeStateServiceImpl implements NoticeStateService {
    public NoticeStateDao noticeStateDaodao = new NoticeStateDaoImpl();
    public NoticeDao noticeDao = new NoticeDaoImpl();

    @Override
    public NoticeState getNoticestateByaccountIdnoticeId(String accountId, Integer noticeId) {
        return noticeStateDaodao.select(accountId, noticeId);
    }

    @Override
    public Integer saveState(NoticeState noticeState) {
        return noticeStateDaodao.insertState(noticeState);
    }

    @Override
    public boolean toggleLike(NoticeState noticeState) {
        if (noticeState.getIsLike() == 0){
            noticeDao.updateNoticeLikes(noticeState.getNoticeId(), 1);

            noticeState.setState(1);
            return noticeStateDaodao.updateIsLike(noticeState) > 0;
        }else {
            noticeDao.updateNoticeLikes(noticeState.getNoticeId(), -1);

            noticeState.setState(0);
            return noticeStateDaodao.updateIsLike(noticeState) > 0;
        }
    }

}
