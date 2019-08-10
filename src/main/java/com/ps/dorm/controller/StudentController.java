package com.ps.dorm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ps.dorm.annotation.RequestMapping;
import com.ps.dorm.domain.ResultDo;
import com.ps.dorm.domain.StudentDo;
import com.ps.dorm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/10 15:51
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    private String ecoding="UTF-8";
    @RequestMapping("/DormSystem/stu/add.do")
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        StudentDo studentDo = value(req, resp);
        studentService.add(studentDo);

    }
    @RequestMapping("/DormSystem/stu/query.do")
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1. 请求乱码
        req.setCharacterEncoding(ecoding);
        // 2. 响应乱码
        resp.setCharacterEncoding(ecoding);
        ResultDo resultDo = new ResultDo();
        List<StudentDo> query = studentService.query();
        resultDo.setBody(query);
        String s = JSONObject.toJSONString(resultDo);

        resp.getWriter().println(s);

    }
    @RequestMapping("/DormSystem/stu/delete.do")
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StudentDo studentDo = value(req, resp);

        studentService.delete(studentDo);

    }
    @RequestMapping("/DormSystem/stu/update.do")
    public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        StudentDo studentDo = value(req, resp);

        studentService.update(studentDo);

    }
    public StudentDo value(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1. 请求乱码
        req.setCharacterEncoding(ecoding);
        // 2. 响应乱码
        resp.setCharacterEncoding(ecoding);

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
        return JSONObject.toJavaObject(str, StudentDo.class);
    }

}
