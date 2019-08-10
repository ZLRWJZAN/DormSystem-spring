package com.ps.dorm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ps.dorm.annotation.RequestMapping;
import com.ps.dorm.domain.DormDo;
import com.ps.dorm.domain.ResultDo;
import com.ps.dorm.service.BuidingService;
import com.ps.dorm.service.DormService;
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
public class DormController {
    private String ecoding="UTF-8";
    @Autowired
    private DormService dormService;

    @Autowired
    private BuidingService buidingService;
    @RequestMapping("/DormSystem/dorm/add.do")
    public String add(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        DormDo dormDo = value(req, resp);

        List<DormDo> dormDos = buidingService.queryId(dormDo);

        String s=JSONObject.toJSONString(dormDos);
        if(s.length()<3){
            return "增加失败,该宿舍楼不存在";
        }else{
            dormService.add(dormDo);
            return "增加成功";
        }

    }
    @RequestMapping("/DormSystem/dorm/query.do")
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1. 请求乱码
        req.setCharacterEncoding(ecoding);
        // 2. 响应乱码
        resp.setCharacterEncoding(ecoding);
        ResultDo resultDo = new ResultDo();
        List<DormDo> query = dormService.query();
        resultDo.setBody(query);
        String s = JSONObject.toJSONString(resultDo);

        resp.getWriter().println(s);

    }
    @RequestMapping("/DormSystem/dorm/delete.do")
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        DormDo dormDo = value(req, resp);

        dormService.delete(dormDo);

    }
    @RequestMapping("/DormSystem/dorm/update.do")
    public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DormDo dormDo = value(req, resp);

        dormService.update(dormDo);

    }
    public DormDo value(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
        return JSONObject.toJavaObject(str, DormDo.class);
    }

}
