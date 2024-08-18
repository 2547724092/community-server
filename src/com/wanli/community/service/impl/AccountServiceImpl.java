package com.wanli.community.service.impl;

import com.wanli.community.dao.AccountDao;
import com.wanli.community.dao.impl.AccountDaoImpl;
import com.wanli.community.entity.Account;
import com.wanli.community.service.AccountService;
import com.wanli.community.util.MD5Utils;

import java.time.LocalDateTime;

public class AccountServiceImpl implements AccountService {
    private AccountDao dao = new AccountDaoImpl();
    @Override
    public Account getAccount(String accountId) {
        return dao.select(accountId);
    }

    @Override
    public boolean register(Account account) {
        // 对密码进行加工加密
        account.setPassword(MD5Utils.md5(MD5Utils.inputPassToNewPass(account.getPassword())));

        // 设置默认参数
        if (account.getAccountName()==null){
            account.setAccountName("取一个名字吧");
        }
        if (account.getAccountImg()==null){
            // 用户未上传图片 取默认头像
            account.setAccountImg("https://www.minecraft.net/content/dam/minecraftnet/games/minecraft/logos/Homepage_Gameplay-Trailer_MC-OV-logo_300x300.png");
        }
        account.setAccountSex(-1);
        account.setCreated(LocalDateTime.now());
        account.setUpdated(LocalDateTime.now());
        account.setState(1);
        account.setDel_tag(1);
        account.setMoney(0.00);

        if (dao.insert(account) > 0) {
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean update(Account account){
        return dao.update(account) > 0;
    }

    @Override
    public boolean updatePassword(Account account){
        // 对密码进行加工加密
        account.setPassword(MD5Utils.md5(MD5Utils.inputPassToNewPass(account.getPassword())));
        return dao.updatePassword(account) > 0;

    }

    @Override
    public boolean updateMoney(String accountId, Double money) {
        return dao.updateMoney(accountId, money) > 0;
    }

    @Override
    public boolean deleteAccount(Account account) {
        return dao.deleteAccount(account) > 0;
    }
}
