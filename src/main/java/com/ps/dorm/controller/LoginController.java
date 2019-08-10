package com.ps.dorm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ps.dorm.annotation.RequestMapping;
import com.ps.dorm.domain.LoginDo;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/13 11:09
 */
@Controller
public class LoginController {
    private String text="false";

    @RequestMapping("/DormSystem/login.do")
    public void Login(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        InputStream iStream = req.getInputStream();
        InputStreamReader isr = new InputStreamReader(iStream, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String p = "";
        String info = "";
        while ((info = br.readLine()) != null) {
            p += info;
        }
        System.out.println("POST参数：" + p);

        JSON str= JSONObject.parseObject(p);
        LoginDo loginDo = JSONObject.toJavaObject(str, LoginDo.class);

        System.out.println(loginDo.getNumber()+"="+loginDo.getPassword());

        if("1".equals(loginDo.getNumber()) && "1".equals(loginDo.getPassword())){
            System.out.println(loginDo.getNumber()+"===="+loginDo.getPassword());
            req.getSession().setAttribute("login",loginDo);

            text="true";
            resp.getWriter().write(text);
            return;
        }

        text="false";
        resp.getWriter().write(text);
    }
}
