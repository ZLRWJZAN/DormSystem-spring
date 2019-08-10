package com.ps.dorm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ps.dorm.Utils.AESUtil;
import com.ps.dorm.annotation.RequestMapping;
import com.ps.dorm.domain.LoginDo;
import com.ps.dorm.emilecode.SendForgetPassword;
import com.ps.dorm.emilecode.SendMail;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/14 12:28
 */
@Controller
public class EmilyCodeController {

    private static SendForgetPassword sendForgetPassword = new SendForgetPassword();
    private static SendMail sendMail = new SendMail();

    @RequestMapping("/DormSystem/emilyCode.do")
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
        System.out.println(p);
        String substring = p.substring(1, p.length() - 1);
        System.out.println(substring);
        if(substring.endsWith("@qq.com")){
            sendMail.send(substring,req,resp);
            String text="true";
            resp.getWriter().write(text);
        }else{
            String text="false";
            resp.getWriter().write(text);
            return;
        }
    }
    @RequestMapping("/DormSystem/forgetPassword.do")
    public void forgetPassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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

        JSON str= JSONObject.parseObject(p);
        LoginDo loginDo = JSONObject.toJavaObject(str, LoginDo.class);
        System.out.println(loginDo.getMailCode());
        if(loginDo.getMailCode().endsWith("@qq.com")){
            SendForgetPassword.send(loginDo.getMailCode(),loginDo.getNumber(),req,resp);
            String text="true";
            resp.getWriter().write(text);
        }else{
            String text="false";
            resp.getWriter().write(text);
            return;
        }
    }

    @RequestMapping("/DormSystem/inputEmilyCode.do")
    public void inputEmilyCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
        Object emilyCode = req.getSession().getAttribute("emilyCode");
        if(sub.equals(emilyCode)){
            String text="true";
            resp.getWriter().write(text);
            return;
        }else{
            String text="false";
            resp.getWriter().write(text);
        }

    }
    @RequestMapping("/DormSystem/decodePassword.do")
    public void decodePassword(HttpServletRequest req, HttpServletResponse resp) throws Exception {
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
        String substring = p.substring(1, p.length() - 1);
        System.out.println(substring);

        String key = (String) req.getServletContext().getAttribute("key");
        System.out.println(key);
        String decode = AESUtil.decode(key, substring);

        String[] split = decode.split("=");

        System.out.println(Arrays.toString(split));
        resp.getWriter().println(split[0]);
    }
}
