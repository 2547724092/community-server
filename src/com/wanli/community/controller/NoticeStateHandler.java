package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.NoticeState;
import com.wanli.community.service.NoticeStateService;
import com.wanli.community.service.impl.NoticeStateServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class NoticeStateHandler {
    private NoticeStateService service = new NoticeStateServiceImpl();

    public Result info(HttpServletRequest request) {
        Integer noticeId = Integer.valueOf(request.getParameter("noticeId"));
        String accountId = (request.getParameter("accountId"));
        NoticeState noticeState = service.getNoticestateByaccountIdnoticeId(accountId, noticeId);
        if (noticeState != null) {
            return Result.success(20000, "公告状态数据请求成功", noticeState);
        } else {
            return Result.fail("公告状态数据请求失败");
        }

    }

    public Result toggleLike(HttpServletRequest request) {
        Integer readId = Integer.valueOf(request.getParameter("readId"));
        Integer isLike = Integer.valueOf(request.getParameter("isLike"));
        Integer noticeId = Integer.valueOf(request.getParameter("noticeId"));


        NoticeState noticeState = new NoticeState();
        noticeState.setReadId(readId);
        noticeState.setIsLike(isLike);
        noticeState.setNoticeId(noticeId);

        if (service.toggleLike(noticeState)){
            return Result.success("点赞状态切换成功");
        } else {
            return Result.fail("点赞状态切换失败");
        }
    }

    public Result saveState(HttpServletRequest request) {
        Integer readId = 0;
        String accountId = request.getParameter("accountId");
        Integer noticeId = Integer.valueOf(request.getParameter("noticeId"));

        NoticeState noticeState = new NoticeState();
        noticeState.setAccountId(accountId);
        noticeState.setNoticeId(noticeId);

        readId = service.saveState(noticeState);

        if (readId != 0) {
            return Result.success("状态更新成功");
        } else {
            return Result.fail("状态更新失败");
        }
    }
}
