package com.wanli.community.dao;

import com.wanli.community.entity.Visitor;

import java.util.List;

public interface VisitorDao {
    //查询访客记录的方法，根据用户 accountId 查询
    public List<Visitor> selectVisitor(String accountId);

    //根据访客记录编号查询访客记录详情
    public List<Visitor> selectVisitorDetails(Integer visitorId);

    //新增访客记录到数据库
    public int saveVisitor(Visitor visitor);

}
