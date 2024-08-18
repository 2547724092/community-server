package com.wanli.community.entity;

import java.time.LocalDateTime;

public class Notice {
    private Integer noticeId;
    private String noticeTitle;
    private String noticeText;
    private String noticeImg;
    private String noticeType;
    private Integer noticeClicks;
    private Integer noticeLikes;
    private LocalDateTime created;
    private NoticeState noticeState;

    public Notice() {
    }

    public Notice(Integer noticeId, String noticeTitle, String noticeText, String noticeImg, String noticeType, Integer noticeClicks, Integer noticeLikes, LocalDateTime created, NoticeState noticeState) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeText = noticeText;
        this.noticeImg = noticeImg;
        this.noticeType = noticeType;
        this.noticeClicks = noticeClicks;
        this.noticeLikes = noticeLikes;
        this.created = created;
        this.noticeState = noticeState;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeText() {
        return noticeText;
    }

    public void setNoticeText(String noticeText) {
        this.noticeText = noticeText;
    }

    public String getNoticeImg() {
        return noticeImg;
    }

    public void setNoticeImg(String noticeImg) {
        this.noticeImg = noticeImg;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public Integer getNoticeClicks() {
        return noticeClicks;
    }

    public void setNoticeClicks(Integer noticeClicks) {
        this.noticeClicks = noticeClicks;
    }

    public Integer getNoticeLikes() {
        return noticeLikes;
    }

    public void setNoticeLikes(Integer noticeLikes) {
        this.noticeLikes = noticeLikes;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public NoticeState getNoticeState() {
        return noticeState;
    }

    public void setNoticeState(NoticeState noticeState) {
        this.noticeState = noticeState;
    }
}
