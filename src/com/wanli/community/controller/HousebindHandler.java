package com.wanli.community.controller;

import com.wanli.community.common.Result;
import com.wanli.community.entity.Housebind;
import com.wanli.community.service.HousebindService;
import com.wanli.community.service.impl.HousebindServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

public class HousebindHandler {
    HousebindService service = new HousebindServiceImpl();

    public Result listByHousebindId(HttpServletRequest request) {
        Integer housebindId = Integer.valueOf(request.getParameter("housebindId"));
        Housebind housebind = service.listByHousebindId(housebindId);

        if (housebind != null) {
            return Result.success(20000, "房屋绑定信息请求成功", housebind);
        } else {
            return Result.fail("房屋绑定信息请求失败");
        }
    }

    public Result listByHouseId(HttpServletRequest request) {
        Integer houseId = Integer.valueOf(request.getParameter("houseId"));
        List<Housebind> list = service.listByHouseId(houseId);

        if (list != null) {
            return Result.success(20000, "房屋绑定信息请求成功", list);
        } else {
            return Result.fail("房屋绑定信息请求失败");
        }
    }

    public Result listByAccountId(HttpServletRequest request) {
        String accountId = request.getParameter("accountId");
        Housebind housebind = service.listByAccountId(accountId);

        if (housebind != null) {
            return Result.success(20000, "房屋绑定信息请求成功", housebind);
        } else {
            return Result.fail("房屋绑定信息请求失败");
        }
    }

    public Result save(HttpServletRequest request) {
        Integer houseId = Integer.valueOf(request.getParameter("houseId"));
        String accountId = request.getParameter("accountId");

        Housebind housebind = new Housebind();
        housebind.setHouseId(houseId);
        housebind.setAccountId(accountId);

        Integer housebindId = service.save(housebind);

        if (housebindId != null){
            return Result.success("房屋绑定录入请求成功");
        } else {
            return Result.fail("房屋绑定信息录入失败");
        }
    }

    public Result update(HttpServletRequest request) {
        Integer housebindId = Integer.valueOf(request.getParameter("housebindId"));
        Integer houseId = Integer.valueOf(request.getParameter("houseId"));
        Housebind housebind = new Housebind();

        housebind.setHouseId(houseId);
        housebind.setHousebindId(housebindId);
        housebind.setUpdated(LocalDateTime.now());

        if (service.update(housebind)) {
            return Result.success("房屋绑定信息更新成功");
        } else {
            return Result.fail("房屋绑定信息更新失败");
        }

    }
}
