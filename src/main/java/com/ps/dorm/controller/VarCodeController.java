package com.ps.dorm.controller;

import com.ps.dorm.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Random;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/13 8:26
 */
@Controller
public class VarCodeController {

    @RequestMapping("/DormSystem/verCode.do")
    public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        Random random = new Random();
        String i =  random.nextInt()+"";
        String code=i.substring(1,5);
        req.getSession().setAttribute("code",code);
        resp.getWriter().write(code);

    }
    @RequestMapping("/DormSystem/verCodeLogin.do")
    public void compareCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        InputStream iStream = req.getInputStream();
        InputStreamReader isr = new InputStreamReader(iStream, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String p="";
        String info ="";
        while ((info = br.readLine()) != null) {
            p += info;
        }
        System.out.println("POST参数:" + p);

        String sub = p.substring(1, p.length() - 1);
        String code =(String) req.getSession().getAttribute("code");
        System.out.println(sub+"========"+code);
        if(code.equals(sub)){
            String text="true";
            resp.getWriter().write(text);
            return;
        }else{
            String text="false";
            resp.getWriter().write(text);
            return;
        }
    }
}
