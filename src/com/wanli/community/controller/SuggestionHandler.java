package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.Report;
import com.wanli.community.entity.Suggestion;
import com.wanli.community.service.SuggestionService;
import com.wanli.community.service.impl.SuggestionServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SuggestionHandler {
    private SuggestionService service = new SuggestionServiceImpl();

    public Result insertSuggestion(HttpServletRequest request){
        Suggestion s = new Suggestion();
        s.setSuggestionContent(request.getParameter("suggestionContent"));
        s.setSuggestionTag(request.getParameter("suggestionTag"));
        s.setSuggestionName(request.getParameter("suggestionName"));
        s.setAccountId(request.getParameter("accountId"));

        if (service.isAdd(s)){
            return Result.success("您的意见、建议提交成功！");
        }else {
            return Result.fail("提交失败");
        }
    }
    public Result selectSuggestionByAccountId(HttpServletRequest request){
        String accountId = request.getParameter("accountId");
        List<Suggestion> suggestion = service.selectByAccountId(accountId);
        if (suggestion!=null){
            return Result.success(suggestion);
        }else {
            return Result.fail("查看投诉记录失败！");
        }
    }

    public Result selectDetailBySuggestionId(HttpServletRequest request){
        Integer suggestionId = Integer.valueOf(request.getParameter("suggestionId"));
        Suggestion suggestion = service.selectDetailBySuggestionId(suggestionId);
        if (suggestion!=null){
            return Result.success(suggestion);
        }
        else {
            return Result.fail("查看记录详情失败");
        }
    }
}
