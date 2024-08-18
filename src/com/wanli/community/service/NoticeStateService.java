package com.wanli.community.service;

import com.wanli.community.entity.NoticeState;

public interface NoticeStateService {
    public NoticeState getNoticestateByaccountIdnoticeId(String accountId, Integer noticeId);

    public Integer saveState(NoticeState noticeState);

    public boolean toggleLike(NoticeState noticeState);
}
