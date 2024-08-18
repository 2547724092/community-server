package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.Account;
import com.wanli.community.service.AccountService;
import com.wanli.community.service.impl.AccountServiceImpl;
import com.wanli.community.util.MD5Utils;

import javax.servlet.http.HttpServletRequest;

public class AccountHandler {
    private AccountService service = new AccountServiceImpl();

    public Result login(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");
        String password = request.getParameter("password");

        Account account = service.getAccount(accountId);

        if (account == null) {
            return Result.fail("账号不存在");
        } else {
            // 将密码加工加密 和数据库的密文比较
            String md5password = MD5Utils.md5(MD5Utils.inputPassToNewPass(password));
            System.out.println("md5password: " + md5password);

            if (account.getPassword().equals(md5password)) {
                if (account.getState() == 0) {
                    return Result.fail("对不起, 账号已被禁用, 解禁请联系管理员");
                } else {
                    return Result.success(account);
                }
            } else {
                return Result.fail("账号密码错误");
            }
        }
    }

    public Result register(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");
        String password = request.getParameter("password");

        Account account = new Account();
        account.setAccountId(accountId);
        account.setPassword(password);

        if (service.register(account)) {
            return Result.success("注册成功");
        } else {
            return Result.fail("注册失败");
        }
    }

    public Result check(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");
        Account account = service.getAccount(accountId);
        if (account == null) {
            return Result.success("手机号码可以注册");
        } else {
            return Result.fail(20005, "手机号码已经被注册, 请更换", "手机号码已经被注册");
        }
    }

    public Result checkPassword(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");
        String password = request.getParameter("password");

        Account account = service.getAccount(accountId);

        String md5password = MD5Utils.md5(MD5Utils.inputPassToNewPass(password));

        if (account.getPassword().equals(md5password)) {
            return Result.success("密码正确");
        } else {
            return Result.fail("密码不正确");
        }

    }


    public Result getAccountByAccountId(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");
        Account account = service.getAccount(accountId);
        if (account != null) {
            return Result.success(20000, "账号信息获取成功", account);
        } else {
            return Result.fail("账号信息获取失败");
        }
    }

    public Result update(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");

        String accountName = request.getParameter("accountName");
        Integer accountSex = Integer.valueOf(request.getParameter("accountSex"));
        String accountImg = request.getParameter("accountImg");

        Account account = new Account();
        account.setAccountName(accountName);
        account.setAccountSex(accountSex);
        account.setAccountImg(accountImg);
        account.setAccountId(accountId);

        if (service.update(account)) {
            return Result.success(account);
        } else {
            return Result.fail("更新账号失败");
        }
    }

    public Result updatePassword(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");

        String password = request.getParameter("password");
        String accountName = request.getParameter("accountName");
        Integer accountSex = Integer.valueOf(request.getParameter("accountSex"));
        String accountImg = request.getParameter("accountImg");

        Account account = new Account();
        account.setPassword(password);
        account.setAccountName(accountName);
        account.setAccountSex(accountSex);
        account.setAccountImg(accountImg);
        account.setAccountId(accountId);

        if (service.update(account)) {
            return Result.success(account);
        } else {
            return Result.fail("更新账号失败");
        }
    }


    public Result updateMoney(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");
        Double money = Double.valueOf(request.getParameter("money"));

        if (service.updateMoney(accountId, money)) {
            return Result.success("余额更新成功");
        } else {
            return Result.fail("余额更新失败");
        }
    }

    public Result delete(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");

        Account account = new Account();
        account.setAccountId(accountId);

        if (service.deleteAccount(account)) {
            return Result.success("账号注销成功");
        } else {
            return Result.fail("账号注销失败");
        }
    }
}
