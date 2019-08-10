package com.ps.dorm.demoClass;

import org.springframework.stereotype.Service;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/13 19:41
 */
public class Stu implements aaa{

    private String name;
    private int age;
    private String sex;

    public void avc(){

    }
    public void bvc(){

    }
    public void cvc(){

    }
    private void a(){

    }
    private void b(){

    }
    protected void c(){

    }

    protected Stu(String name){
        this.name = name;
    }

    public Stu() {

    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Stu(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void aaaaaaa() {

    }
}
