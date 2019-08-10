package com.ps.dorm.domain;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/10 15:43
 */
public class StudentDo {
    private int id;
    private String name;
    private int sex;
    private int dormId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getDormId() {
        return dormId;
    }

    public void setDormId(int dormId) {
        this.dormId = dormId;
    }
}
