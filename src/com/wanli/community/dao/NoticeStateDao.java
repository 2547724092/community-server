package com.wanli.community.dao;

import com.wanli.community.entity.NoticeState;

public interface NoticeStateDao {
    public NoticeState select(String accountId, Integer noticeId);

    public int insertState(NoticeState noticeState);

    public int updateIsLike(NoticeState noticeState);
}
