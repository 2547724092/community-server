package com.wanli.community.entity;

import java.time.LocalDateTime;

public class Visitor {
    private Integer visitorId;
    private String accountId;
    private String visitorName;
    private LocalDateTime visitorCome;
    private LocalDateTime visitorGo;
    private String visitorReason;
    private String visitorImg;
    private LocalDateTime visitorSubmit;
    private String auditResults;
    private String reviewer;
    private LocalDateTime auditDate;
    private Integer state;

    public Visitor() {
    }

    public Visitor(Integer visitorId, String accountId, String visitorName, LocalDateTime visitorCome, LocalDateTime visitorGo, String visitorReason, String visitorImg, LocalDateTime visitorSubmit, String auditResults, String reviewer, LocalDateTime auditDate, Integer state) {
        this.visitorId = visitorId;
        this.accountId = accountId;
        this.visitorName = visitorName;
        this.visitorCome = visitorCome;
        this.visitorGo = visitorGo;
        this.visitorReason = visitorReason;
        this.visitorImg = visitorImg;
        this.visitorSubmit = visitorSubmit;
        this.auditResults = auditResults;
        this.reviewer = reviewer;
        this.auditDate = auditDate;
        this.state = state;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public LocalDateTime getVisitorCome() {
        return visitorCome;
    }

    public void setVisitorCome(LocalDateTime visitorCome) {
        this.visitorCome = visitorCome;
    }

    public LocalDateTime getVisitorGo() {
        return visitorGo;
    }

    public void setVisitorGo(LocalDateTime visitorGo) {
        this.visitorGo = visitorGo;
    }

    public String getVisitorReason() {
        return visitorReason;
    }

    public void setVisitorReason(String visitorReason) {
        this.visitorReason = visitorReason;
    }

    public String getVisitorImg() {
        return visitorImg;
    }

    public void setVisitorImg(String visitorImg) {
        this.visitorImg = visitorImg;
    }

    public LocalDateTime getVisitorSubmit() {
        return visitorSubmit;
    }

    public void setVisitorSubmit(LocalDateTime visitorSubmit) {
        this.visitorSubmit = visitorSubmit;
    }

    public String getAuditResults() {
        return auditResults;
    }

    public void setAuditResults(String auditResults) {
        this.auditResults = auditResults;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public LocalDateTime getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(LocalDateTime auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
