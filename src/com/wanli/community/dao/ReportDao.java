package com.wanli.community.dao;

import com.wanli.community.entity.Report;

import java.util.List;

public interface ReportDao {
    //报修记录按accountId查询
    public List<Report> selectByAccountId(String accountId);

    //通过reportId查看维修详情
    public Report selectReportDetailOne(Integer reportId);

    //“我要报修”功能实现 提交报修信息
    public int add(Report report);
}
