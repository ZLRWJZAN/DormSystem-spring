package com.ps.dorm.controller;

import com.ps.dorm.annotation.RequestMapping;
import com.ps.dorm.notecode.PhoneCode;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/14 11:39
 */
@Controller
public class NoteCodeController {
    private static PhoneCode phoneCode = new PhoneCode();


    @RequestMapping("/DormSystem/noteCode.do")
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
        String substring = p.substring(1, p.length() - 1);
        System.out.println(substring.length());
        System.out.println(substring.length()==11);
        if(substring.length()==11){
            phoneCode.getPhonemsg(substring);
            String text="true";
            resp.getWriter().write(text);
        }else{
            String text="false";
            resp.getWriter().write(text);
            return;
        }


        //
    }
}
