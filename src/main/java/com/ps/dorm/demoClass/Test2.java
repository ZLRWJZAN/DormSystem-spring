package com.ps.dorm.demoClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/13 22:32
 */
public class Test2 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Stu stu = new Stu();
        stu.setName("阿猫");

        System.out.println(getAttrbute1(stu,"name"));


    }
    public static String  getAttrbute(Object obj , String fieldName) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = obj.getClass();
        /*Method getName = aClass.getMethod("getName");
        System.out.println(getName);
        Object invoke = getName.invoke(obj);
        System.out.println(invoke);*/
        //return (String) aClass.getDeclaredField(name).isAccessible(true).get(obj);
        Field declaredField = aClass.getDeclaredField(fieldName);
        declaredField.setAccessible(true);
        Object o= declaredField.get(obj);
        return o.toString();
    }
    public static String  getAttrbute1(Object obj , String fieldName) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class aClass = obj.getClass();
        String change = change(fieldName);
        String concat = "get".concat(change);

        Field declaredField = aClass.getDeclaredField(fieldName);
        System.out.println(declaredField);
        Method method = aClass.getMethod(concat, obj.getClass());
        String invoke = (String) method.invoke(obj);
        //declaredField.setAccessible(true);

        return invoke;
    }
    public static String change(String fieldName){
        String s = fieldName.substring(0, 1).toUpperCase();
        String substring = fieldName.substring(1, fieldName.length());
        return s.concat(substring);
    }

}
