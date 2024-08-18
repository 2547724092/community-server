package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.Notice;
import com.wanli.community.service.impl.NoticeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.security.PublicKey;
import java.util.List;

public class NoticeHandler {
    private NoticeServiceImpl service = new NoticeServiceImpl();

    //查询公告信息
    public Result listNoticeByNoticeId(HttpServletRequest request) {

        Integer noticeId = Integer.valueOf(request.getParameter("noticeId"));
        List<Notice> list = service.listNoticeByNoticeId(noticeId);
        if (list != null) {
            return Result.success(list);
        } else {
            return Result.fail("公告信息获取失败");
        }
    }

    public Result listNoticeWithState(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");

        List<Notice> list = service.listNoticeWithState(accountId);

        if (list != null) {
            return Result.success(20000, "公告与状态数据请求成功", list);
        } else {
            return Result.fail("公告与状态数据请求失败");
        }
    }

    public Result listNoticeWithStateById(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");
        Integer noticeId = Integer.valueOf(request.getParameter("noticeId"));

        Notice notice = service.listNoticeWithStateById(accountId, noticeId);

        if (notice != null) {
            return Result.success(20000, "公告与状态数据请求成功", notice);
        } else {
            return Result.fail("公告与状态数据请求失败");
        }
    }

    public Result updateClicks(HttpServletRequest request) {
        try {
            Integer noticeId = Integer.valueOf(request.getParameter("noticeId"));
            service.handleNoticeClick(noticeId);
            return Result.success("通知点击数更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("通知点击数更新失败");
        }
    }

}
