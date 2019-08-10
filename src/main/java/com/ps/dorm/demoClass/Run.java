package com.ps.dorm.demoClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/13 19:42
 */
public class Run {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Stu stu = new Stu();
        Class aClass = stu.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method s:declaredMethods) {
            System.out.println(s);
        }
        System.out.println("-----------------------------------");


        Class [] interfaces = aClass.getInterfaces();
        for (Class c:interfaces){
            System.out.println(c);
        }
        System.out.println("-----------------------------------");
        ClassLoader classLoader = aClass.getClassLoader();
        System.out.println(classLoader);
        System.out.println("-----------------------------------");
        Constructor [] constructors = aClass.getConstructors();
        for (Constructor connection:constructors){
            System.out.println(connection);
        }
        System.out.println("-----------------------------------");
        Class<Stu> stuClass = Stu.class;

        Annotation[] declaredAnnotations = stuClass.getDeclaredAnnotations();
        for (Annotation de:declaredAnnotations){
            System.out.println(de);
        }
        System.out.println("-----------------1------------------");


        Class<?> aClass1 = Class.forName("com.ps.dorm.demoClass.Stu");
        Constructor<?>[] constructors1 = aClass1.getConstructors();
        for (Constructor c: constructors1) {
            System.out.println(c);
        }
        System.out.println("-----------------------------------");
        Constructor<?>[] declaredConstructors = aClass1.getDeclaredConstructors();
        for (Constructor cc:declaredConstructors){
            System.out.println(cc);
        }

        System.out.println("----------------2-------------------");
        Field[] declaredFields = aClass1.getDeclaredFields();
        for (Field f:declaredFields){
            System.out.println(f);
        }
        System.out.println("-----------------------------------");
        Class[] classes = aClass.getClasses();
        for (Class c:classes){
            System.out.print(c);
        }
        System.out.println("-----------------------------------");
        System.out.println(aClass1.getTypeName());
        System.out.println("-----------------------------------");
        System.out.println(aClass.getTypeName());
        System.out.println("-----------------------------------");
        Field[] declaredFields1 = aClass.getDeclaredFields();
        for (Field d:declaredFields1){
            System.out.println(d);
        }
        System.out.println("-----------------------------------");

        try {
            Method aaa = aClass.getMethod("aaa");
            System.out.println(aaa);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------");
        Method stu1 = aClass.getDeclaredMethod("getName");
        System.out.println(stu1);


        System.out.println("-----------------------------------");

        Class<?> clazz= Class.forName("com.ps.dorm.demoClass.Stu");
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class,String.class);
        Stu xm = (Stu) constructor.newInstance("小米", 18,"女");
        System.out.println(xm.getName());
        Method getName = xm.getClass().getMethod("getName");
        Stu st = (Stu) clazz.newInstance();
        st.setName("张三");
        System.out.println(st.getName());
        System.out.println("----------------3-------------------");
        Field age = aClass.getField("name1");
        System.out.println(age);

        System.out.println("-----------------------------------");
        Field[] declaredFields2 = aClass.getDeclaredFields();
        for (Field f:declaredFields2){
            System.out.println(f);
        }
        System.out.println("-----------------4------------------");

        Method[] methods = aClass.getMethods();
        for (Method m:methods){
            System.out.println(m);
        }

        System.out.println("-----------------------------------");
        Method[] declaredMethods1 = aClass.getDeclaredMethods();
        for (Method m:declaredMethods1){
            System.out.println(m);
        }

        System.out.println("-----------------5------------------");

        String str=new String();
        str.getClass();
        Integer integer = new Integer("1");
        integer.getClass();
        String[] strings = new String['d'];
        strings.getClass();


        Class c=List[].class;
    }
}
