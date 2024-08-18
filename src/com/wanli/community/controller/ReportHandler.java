package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.Report;
import com.wanli.community.service.ReportService;
import com.wanli.community.service.impl.ReportServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ReportHandler {
    private ReportService service = new ReportServiceImpl();

    //查看accountId下的报修记录数据
    public Result listByAccountId(HttpServletRequest request){
        String accountId = request.getParameter("accountId");
        List<Report> report = service.selectByAccountId(accountId);
        if (report!=null){
            return Result.success(report);
        }else {
            return Result.fail("查看该账户下的报修记录失败！");
        }
    }

    //通过reportId查看报修的详细信息及处理意见
    public Result listDetailsByReportId(HttpServletRequest request){
        Integer reportId = Integer.valueOf(request.getParameter("reportId"));
        Report detail = service.selectInfoByReportId(reportId);
        if (detail!=null){
            return Result.success(detail);
        }else {
            return Result.fail("维修详情查看失败！");
        }
    }
    //添加报修数据至数据库
    public Result insert(HttpServletRequest request){
        //共13个字段，其中，reportId为主键不写、自动递增，state、reviewer、auditTime、reportSubmit、auditResults不写，
        Report report = new Report();
        report.setReportAddress(request.getParameter("reportAddress"));
        report.setReportTime(request.getParameter("reportTime"));
        report.setReportName(request.getParameter("reportName"));
        report.setAccountId(request.getParameter("accountId"));
        report.setReportType(request.getParameter("reportType"));
        report.setReportContent(request.getParameter("reportContent"));
        report.setReportImg(request.getParameter("reportImg"));

        if (service.isAdd(report)){
            return Result.success("报修记录添加成功");
        }else {
            return Result.fail("报修记录添加失败");
        }
    }

}
