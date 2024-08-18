package com.wanli.community.service.impl;

import com.wanli.community.dao.VisitorDao;
import com.wanli.community.dao.impl.VisitorDaoImpl;
import com.wanli.community.entity.Visitor;
import com.wanli.community.service.VisitorService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VisitorServiceImpl implements VisitorService {
    private VisitorDao dao = new VisitorDaoImpl();

    @Override
    public List<Visitor> listVisitorByAccountId(String accountId) {
        List<Visitor> list = new ArrayList<>();
        list = dao.selectVisitor(accountId);
        return list;
    }

    @Override
    public List<Visitor> listVisitorByVisitorId(Integer visitorId) {
        List<Visitor> list = new ArrayList<>();
        list = dao.selectVisitorDetails(visitorId);
        return list;
    }

    @Override
    public boolean saveVisitor(Visitor visitor) {
        //设置提交时间为当前时间
        visitor.setVisitorSubmit(LocalDateTime.now());
        visitor.setState(2);  //默认审核状态
        if (dao.saveVisitor(visitor) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
