package com.ps.dorm.demoClass;

import java.lang.reflect.Field;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/14 8:51
 */
public class Test4 {
    public static void main(String[] args) throws IllegalAccessException {
        Stu stu=new Stu();
        stu.setName("张三");
        stu.setAge(18);
        stu.setSex("男");
        toJson(stu);

    }
    public static void toJson(Object obj) throws IllegalAccessException {
        Class<?> aClass = obj.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        String c="";
        for (int i = 0; i <declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            if(i!=declaredFields.length-1){
                c+="\""+declaredFields[i].getName()+"\""+":"+"\""+declaredFields[i].get(obj)+"\",";
            }else{
                c+="\""+declaredFields[i].getName()+"\""+":"+"\""+declaredFields[i].get(obj)+"\"";
            }
        }
        System.out.println("{"+c+"}");
    }

}
