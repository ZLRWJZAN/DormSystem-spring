package com.ps.dorm.demoClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/13 22:12
 */
public class Test {
    public static void main(String[] args) {
        Object obj=new Stu();
        print(obj);
    }
    public static void print(Object obj){
        Class<?> aClass = obj.getClass();
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor c:declaredConstructors){
            System.out.println(c);
        }
        System.out.println("构造器:"+declaredConstructors.length+"个");

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f:declaredFields){
            System.out.println(f);
        }
        System.out.println("字段:"+declaredFields.length+"个");

        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method:declaredMethods){
            System.out.println(method);
        }
        System.out.println("方法:"+declaredMethods.length+"个");
    };
}
