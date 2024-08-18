package com.wanli.community.entity;

public class NoticeState {
    //数据库映射字段
    private Integer readId;
    private Integer noticeId;
    private String accountId;
    private Integer state;
    private Integer isLike;

    public NoticeState() {
    }

    public NoticeState(Integer readId, Integer noticeId, String accountId, Integer state, Integer isLike) {
        this.readId = readId;
        this.noticeId = noticeId;
        this.accountId = accountId;
        this.state = state;
        this.isLike = isLike;
    }

    public Integer getReadId() {
        return readId;
    }

    public void setReadId(Integer readId) {
        this.readId = readId;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }
}
