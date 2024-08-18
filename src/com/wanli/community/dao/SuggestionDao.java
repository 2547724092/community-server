package com.wanli.community.dao;

import com.wanli.community.entity.Report;
import com.wanli.community.entity.Suggestion;

import java.util.List;

public interface SuggestionDao {
    //添加意见投诉\建议
    public int add(Suggestion suggestion);

    //按AccountId查看名下所有物业投诉信息
    public List<Suggestion> selectSuggestionByAccountId(String accountId);

    //点击详情传递suggestionId查看具体投诉、反馈信息
    public Suggestion selectDetailBySuggestionId(Integer suggestionId);
}
