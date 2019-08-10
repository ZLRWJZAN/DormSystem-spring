package com.ps.dorm.demoClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/14 8:06
 */
public class Test3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Stu stu = new Stu();
        setAttrbute1(stu,"name","大海");
        System.out.println(stu.getName());
    }
    public static void setAttrbute(Object obj, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Class<?> aClass = obj.getClass();
        Field declaredField = aClass.getDeclaredField(fieldName);
        declaredField.setAccessible(true);
        declaredField.set(obj, value);
    }
    public static void setAttrbute1(Object obj, String fieldName, Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = obj.getClass();
        String change = change(fieldName);
        String concat = "set".concat(change);
        Method method = aClass.getMethod(concat, String.class);
        method.invoke(obj,value);
        //System.out.println(method);
        //method.invoke(value,obj);
    }
    public static String change(String fieldName){
        String s = fieldName.substring(0, 1).toUpperCase();
        String substring = fieldName.substring(1, fieldName.length());
        return s.concat(substring);
    }


}
