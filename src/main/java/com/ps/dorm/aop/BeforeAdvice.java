package com.ps.dorm.aop;

import com.ps.dorm.annotation.ShowLog;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/18 21:53
 */
public class BeforeAdvice implements MethodBeforeAdvice {
    /**
     * method：切入点的方法名
     * objects：切入点方法的参数
     * o：切入点的对象
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("调用的方法:"+method.getName());
        for (Object object:objects){
            System.out.println("参数:"+object);
        }
    }
}
