package com.wanli.community.service;

import com.wanli.community.entity.Report;
import com.wanli.community.entity.Suggestion;

import java.util.List;

public interface SuggestionService {
    //添加投诉记录
    public boolean isAdd(Suggestion s);
    //查找当前联系人所有投诉记录
    public List<Suggestion> selectByAccountId(String accountId);

    public Suggestion selectDetailBySuggestionId(Integer suggestionId);
}
