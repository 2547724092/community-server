package com.wanli.community.service.impl;

import com.wanli.community.dao.SuggestionDao;
import com.wanli.community.dao.impl.SuggestionDaoImpl;
import com.wanli.community.entity.Suggestion;
import com.wanli.community.service.SuggestionService;

import java.time.LocalDateTime;
import java.util.List;

public class SuggestionServiceImpl implements SuggestionService {
    private SuggestionDao dao = new SuggestionDaoImpl();
    @Override
    public boolean isAdd(Suggestion s) {
        s.setSuggestionTime(LocalDateTime.now());
        s.setAuditTime(null);
        s.setAuditResults("等待结果中");
        s.setState(0);
        //设置状态 刚提交报修为 1 已完工 0 处理中

        if (dao.add(s)>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Suggestion> selectByAccountId(String accountId) {
        List<Suggestion> list = dao.selectSuggestionByAccountId(accountId);
        return list;
    }

    @Override
    public Suggestion selectDetailBySuggestionId(Integer suggestionId) {
        Suggestion s = dao.selectDetailBySuggestionId(suggestionId);
        return s;
    }


}
