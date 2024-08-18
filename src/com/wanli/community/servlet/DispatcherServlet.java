package com.wanli.community.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanli.community.task.ReleaseParking;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Timer;

public class DispatcherServlet extends HttpServlet {
    private Timer timer;
    @Override
    public void init() throws ServletException {
        super.init();
        timer = new Timer(true); // true 表示为守护线程
        timer.scheduleAtFixedRate(new ReleaseParking(), 0, 60000); // 每分钟执行一次
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 拦截所有请求
        System.out.println("----------------DispatcherServlet get----------------");


        // 中文编码 设置 req和 resp
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");


        PrintWriter out = response.getWriter();


        String path = request.getServletPath(); // 获得上下文后的路径
        String className = path.substring(1, path.lastIndexOf("/"));
        String methodName = path.substring(path.lastIndexOf("/") + 1);

        try {
            System.out.println("className: com.wanli.community.controller." + className);
            System.out.println("methodName: " + methodName);

            Class<?> clazz = Class.forName("com.wanli.community.controller." + className);

            Object controller = clazz.newInstance();


            Method method = clazz.getMethod(methodName, HttpServletRequest.class);

            Object result = method.invoke(controller, request);

//            System.out.println(result.toString());

//             如果是查询操作, 返回result中存储的就是返回给前端查询数据
            ObjectMapper om = new ObjectMapper();
            out.println(om.writeValueAsString(result));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    public void destroy() {
        super.destroy();
        timer.cancel();
    }
}
