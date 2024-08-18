package com.wanli.community.entity;

import java.time.LocalDateTime;

public class Suggestion {
    private String ID;
    private Integer suggestionId;
    private String accountId;
    private String suggestionName;
    private String suggestionContent;
    private String suggestionTag;
    private LocalDateTime suggestionTime;
    private String auditResults;
    private LocalDateTime auditTime;
    private Integer state;

    public Suggestion() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Integer getSuggestionId() {
        return suggestionId;
    }

    public void setSuggestionId(Integer suggestionId) {
        this.suggestionId = suggestionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSuggestionName() {
        return suggestionName;
    }

    public void setSuggestionName(String suggestionName) {
        this.suggestionName = suggestionName;
    }

    public String getSuggestionContent() {
        return suggestionContent;
    }

    public void setSuggestionContent(String suggestionContent) {
        this.suggestionContent = suggestionContent;
    }

    public String getSuggestionTag() {
        return suggestionTag;
    }

    public void setSuggestionTag(String suggestionTag) {
        this.suggestionTag = suggestionTag;
    }

    public LocalDateTime getSuggestionTime() {
        return suggestionTime;
    }

    public void setSuggestionTime(LocalDateTime suggestionTime) {
        this.suggestionTime = suggestionTime;
    }

    public String getAuditResults() {
        return auditResults;
    }

    public void setAuditResults(String auditResults) {
        this.auditResults = auditResults;
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
        return "Suggestion{" +
                "suggestionId=" + suggestionId +
                ", accountId='" + accountId + '\'' +
                ", suggestionName='" + suggestionName + '\'' +
                ", suggestionContent='" + suggestionContent + '\'' +
                ", suggestionTag='" + suggestionTag + '\'' +
                ", suggestionTime=" + suggestionTime +
                ", auditResults='" + auditResults + '\'' +
                ", auditTime=" + auditTime +
                ", state=" + state +
                '}';
    }
}
