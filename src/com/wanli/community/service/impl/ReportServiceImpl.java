package com.wanli.community.service.impl;

import com.wanli.community.dao.impl.ReportDaoImpl;
import com.wanli.community.dao.ReportDao;
import com.wanli.community.entity.Report;
import com.wanli.community.service.ReportService;

import java.time.LocalDateTime;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private ReportDao dao = new ReportDaoImpl();
    @Override
    public boolean isAdd(Report report) {
        report.setReportSubmit(LocalDateTime.now());
        report.setReviewer("物业部门");
        //设置状态 刚提交报修为 1 已完工 0 处理中
        report.setState(0);

        if (dao.add(report)>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Report> selectByAccountId(String accountId) {
        List<Report> list = dao.selectByAccountId(accountId);
        return list;
    }

    @Override
    public Report selectInfoByReportId(Integer reportId) {
        Report report = dao.selectReportDetailOne(reportId);
        return report;
    }
}
