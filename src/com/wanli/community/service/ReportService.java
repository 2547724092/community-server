package com.wanli.community.service;

import com.wanli.community.common.Result;
import com.wanli.community.entity.Report;

import java.util.List;

public interface ReportService {
    //添加至数据表report中，设置一些字段的默认值，若添加成功则返回true
    public boolean isAdd(Report report);

    public List<Report> selectByAccountId(String accountId);

    public Report selectInfoByReportId(Integer reportId);
}
