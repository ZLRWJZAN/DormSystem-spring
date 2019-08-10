package com.ps.dorm.servlet;


import com.ps.dorm.Utils.ClassScaner;
import com.ps.dorm.Utils.Scan;
import com.ps.dorm.annotation.RequestMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/19 16:04
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

    private String encoding = "UTF-8";
    private Map<String,Handle> map=new HashMap<>();

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<Class> print = Scan.print("com.ps.dorm.controller");
        // 2. 只需要@Controller注解的 ，过滤掉没有Controller注解的类
        print = print.stream().filter( i -> i.isAnnotationPresent(Controller.class)).collect(Collectors.toList());

        // 3. 构建映射关系
        for(Class c : print) {
            Method[] methods = c.getDeclaredMethods();

            for(Method m : methods) {
                // a. 判断是否有RequestMapping注解
                RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
                if(requestMapping == null) {
                    continue;
                }
                // b. handlerMapping
                Handle handle = new Handle();
                handle.setMethod(m);
                handle.setController(context.getBean(c));
                map.put(requestMapping.value(), handle);
            }
        }

        /*Set<Class> scan = ClassScaner.scan("com.ps.dorm.controller");
        for (Class c:scan){
            System.out.println(c+"   3");
            if(c.isAnnotationPresent(Controller.class)){

                Method[] declaredMethods = c.getDeclaredMethods();
                for (Method method:declaredMethods){
                    RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                    if(annotation==null){
                        return;
                    }
                    Handle handle = new Handle();
                    handle.setMethod(method);
                    handle.setController(context.getBean(c));
                    map.put(annotation.value(),handle);
                }
            }
        }*/
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 请求乱码
        req.setCharacterEncoding(encoding);

        // 2. 响应乱码
        resp.setCharacterEncoding(encoding);

        String requestURI = req.getRequestURI();
        Handle handle = map.get(requestURI);
        if(handle==null){
            return;
        }
        try {
            handle.getMethod().invoke(handle.getController(),req,resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    class Handle{
        private Object controller;
        private Method method;

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        @Override
        public String toString() {
            return "Handle{" +
                    "controller=" + controller +
                    ", method=" + method +
                    '}';
        }
    }
}