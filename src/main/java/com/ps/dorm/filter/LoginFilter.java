package com.ps.dorm.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ps.dorm.domain.LoginDo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/13 10:51
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        List<String> list=new ArrayList<>();
        list.add("/DormSystem/login.html");
        list.add("/DormSystem/dist/pages/management/forgetPassword.html");
        list.add("/DormSystem/dist/pages/management/updatePassword.html");
        if(list.contains(requestURI) || requestURI.endsWith(".js") || requestURI.endsWith(".css") || requestURI.endsWith(".jpg")|| requestURI.endsWith(".png")|| requestURI.endsWith(".do")){
            filterChain.doFilter(req,resp);
            return;
        }
        HttpSession session = req.getSession();
        if(session==null){
            resp.setContentType("application/json;charset=utf-8");
            resp.setHeader("Refresh","3;URL=/DormSystem/login.html");
            resp.getWriter().write("三秒后将返回登录界面");
            return;
        }
        LoginDo login= (LoginDo) session.getAttribute("login");
        if(login==null){
            resp.setContentType("application/json;charset=utf-8");
            resp.setHeader("Refresh","3;URL=/DormSystem/login.html");
            resp.getWriter().write("三秒后将返回登录界面");
            return;
        }

        filterChain.doFilter(req,resp);
    }
    @Override
    public void destroy() {

    }
}
