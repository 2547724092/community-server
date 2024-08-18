package com.wanli.community.dao;

import com.wanli.community.entity.Account;

public interface AccountDao {
    // 登录-查询账号
    public Account select(String accountId);

    // 注册-插入新的用户信息
    public Integer insert(Account account);

    public Integer update(Account account);
    public Integer updatePassword(Account account);

    public Integer updateMoney(String accountId, Double money);

    public Integer deleteAccount(Account account);

}
