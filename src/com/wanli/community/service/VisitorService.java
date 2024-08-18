package com.wanli.community.service;

import com.wanli.community.dao.VisitorDao;
import com.wanli.community.entity.Notice;
import com.wanli.community.entity.Visitor;

import java.util.List;

public interface VisitorService {
    //根据用户编号查询该用户的访客记录
    public List<Visitor> listVisitorByAccountId(String accountId);

    //根据访客记录编号查询访客记录详情
    public List<Visitor> listVisitorByVisitorId(Integer visitorId);

    public boolean saveVisitor(Visitor visitor);
}
