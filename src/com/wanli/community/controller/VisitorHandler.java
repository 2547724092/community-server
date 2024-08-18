package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.dao.impl.VisitorDaoImpl;
import com.wanli.community.entity.Notice;
import com.wanli.community.entity.Visitor;
import com.wanli.community.service.impl.VisitorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class VisitorHandler {
    private VisitorServiceImpl service = new VisitorServiceImpl();

    public Result listVisitorByAccountId(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");
        List<Visitor> list = service.listVisitorByAccountId(accountId);
        if (list != null) {
            return Result.success(20000, "访客记录获取成功", list);
        } else {
            return Result.fail("访客信息获取失败");
        }
    }

    public Result selectVisitorDetails(HttpServletRequest request) {
        Integer visitorId = Integer.valueOf(request.getParameter("visitorId"));
        List<Visitor> list = service.listVisitorByVisitorId(visitorId);
        if (list != null) {
            return Result.success(20000, "访客记录获取成功", list);
        } else {
            return Result.fail("访客信息获取失败");
        }
    }

    public Result saveVisitor(HttpServletRequest request) {
        String visitorName = request.getParameter("visitorName");
        String accountId = request.getParameter("accountId");
        LocalDateTime visitorCome = LocalDateTime.parse(request.getParameter("visitorCome"));
        LocalDateTime visitorGo = LocalDateTime.parse(request.getParameter("visitorGo"));
        String visitorReason = request.getParameter("visitorReason");
        String visitorImg = request.getParameter("visitorImg");

        Visitor visitor = new Visitor();
        visitor.setVisitorName(visitorName);
        visitor.setAccountId(accountId);
        visitor.setVisitorCome(visitorCome);
        visitor.setVisitorGo(visitorGo);
        visitor.setVisitorReason(visitorReason);

        //添加头像
        visitor.setVisitorImg(visitorImg);

        if (service.saveVisitor(visitor)) {
            return Result.success(20000,"申请提交成功",visitor);
        } else {
            return Result.fail("申请提交失败");
        }
    }
}
