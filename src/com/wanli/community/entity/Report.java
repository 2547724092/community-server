package com.wanli.community.entity;

import java.time.LocalDateTime;

public class Report {
    private Integer reportId;
    private String reportTime;
    private String accountId;
    private String reportName;
    private String reportType;
    private String reportContent;
    private String reportImg;
    private String reportAddress;
    private LocalDateTime reportSubmit;
    private String auditResults;
    private String reviewer;
    private LocalDateTime auditTime;
    private Integer state;
    public Report() {
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReportImg() {
        return reportImg;
    }

    public void setReportImg(String reportImg) {
        this.reportImg = reportImg;
    }

    public String getReportAddress() {
        return reportAddress;
    }

    public void setReportAddress(String reportAddress) {
        this.reportAddress = reportAddress;
    }

    public LocalDateTime getReportSubmit() {
        return reportSubmit;
    }

    public void setReportSubmit(LocalDateTime reportSubmit) {
        this.reportSubmit = reportSubmit;
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

    public LocalDateTime getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(LocalDateTime auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", reportTime='" + reportTime + '\'' +
                ", accountId='" + accountId + '\'' +
                ", reportName='" + reportName + '\'' +
                ", reportType='" + reportType + '\'' +
                ", reportContent='" + reportContent + '\'' +
                ", reportImg='" + reportImg + '\'' +
                ", reportAddress='" + reportAddress + '\'' +
                ", reportSubmit=" + reportSubmit +
                ", auditResults='" + auditResults + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", auditTime=" + auditTime +
                ", state=" + state +
                '}';
    }
}
