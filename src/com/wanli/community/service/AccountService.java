package com.wanli.community.service;

import com.wanli.community.entity.Account;

public interface AccountService {
    public Account getAccount(String accountId);

    public boolean register(Account account);

    public boolean update(Account account);

    public boolean updatePassword(Account account);

    public boolean updateMoney(String accountId, Double money);

    public boolean deleteAccount(Account account);

}
