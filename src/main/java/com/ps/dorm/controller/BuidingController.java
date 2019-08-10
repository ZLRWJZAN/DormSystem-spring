package com.ps.dorm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ps.dorm.annotation.RequestMapping;
import com.ps.dorm.domain.BuidingDo;
import com.ps.dorm.domain.ResultDo;
import com.ps.dorm.service.BuidingService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/DormSystem/buiding")
public class BuidingController {
    private String ecoding="UTF-8";
    @Autowired
    private BuidingService buidingService;

    @RequestMapping("/DormSystem/buiding/add.do")
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BuidingDo buidingDo = value(req, resp);

        buidingService.add(buidingDo);
    }
    @RequestMapping("/DormSystem/buiding/query.do")
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1. 请求乱码
        req.setCharacterEncoding(ecoding);
        // 2. 响应乱码
        resp.setContentType("application/json;charset=utf-8");
        ResultDo resultDo = new ResultDo();
        List<BuidingDo> query = buidingService.query();
        resultDo.setBody(query);
        String s = JSONObject.toJSONString(resultDo);
        /*JSONObject jsonObject = JSONObject.parseObject(s);*/

        resp.getWriter().println(s);

    }
    @RequestMapping("/DormSystem/buiding/delete.do")
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BuidingDo buidingDo = value(req, resp);

        buidingService.delete(buidingDo);

    }
    @RequestMapping("/DormSystem/buiding/update.do")
    public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        BuidingDo buidingDo = value(req, resp);

        buidingService.update(buidingDo);

    }

    public BuidingDo value(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
        return JSONObject.toJavaObject(str, BuidingDo.class);
    }
}
