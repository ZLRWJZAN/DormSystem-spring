package com.ps.dorm.servlet;

import com.ps.dorm.controller.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/10 15:46
 */
//@WebServlet("*.do")
public class ServletAll extends HttpServlet {
    private Map<String,Object> map=new HashMap();

    @Override
    public void init(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        map.put("buiding",context.getBean(BuidingController.class));
        map.put("dorm",context.getBean(DormController.class));
        map.put("stu",context.getBean(StudentController.class));
    }
    private VarCodeController varCodeController = new VarCodeController();

    private LoginController loginController=new LoginController();

    private NoteCodeController noteCodeController=new NoteCodeController();

    private EmilyCodeController emilyCodeController = new EmilyCodeController();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        String[] split1 = requestURI.replace(".do","").split("/");
        if(split1[2].equals("buiding") || split1[2].equals("dorm") || split1[2].equals("stu")){
            System.out.println(Arrays.toString(split1));
            String classKey=split1[2];
            String value=split1[3];
            //通过classKey,获取值
            Object o = map.get(classKey);
            Method method=null;
            try {
                //获取o的class对象,再根据方法名和参数值获取到某个方法
                method= o.getClass().getMethod(value,HttpServletRequest.class,HttpServletResponse.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            try {
                //执行该方法
                method.invoke(o,req,resp);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return ;
        }else{
            if("/DormSystem/login.do".equals(requestURI)){
                loginController.Login(req,resp);
                return;
            }
            if("/DormSystem/verCode.do".equals(requestURI)){
                varCodeController.getCode(req,resp);
                return;
            }
            if("/DormSystem/verCodeLogin.do".equals(requestURI)){
                varCodeController.compareCode(req,resp);
                return;
            }
            if("/DormSystem/noteCode.do".equals(requestURI)){
                noteCodeController.compareCode(req,resp);
                return;
            }
            if("/DormSystem/emilyCode.do".equals(requestURI)){
                emilyCodeController.compareCode(req,resp);
                return;
            }
            if("/DormSystem/inputEmilyCode.do".equals(requestURI)){
                emilyCodeController.inputEmilyCode(req,resp);
                return;
            }

            if("/DormSystem/forgetPassword.do".equals(requestURI)){
                emilyCodeController.forgetPassword(req,resp);
                return;
            }
        }
    }
}
