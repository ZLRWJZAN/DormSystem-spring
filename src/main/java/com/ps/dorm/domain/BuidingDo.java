package com.ps.dorm.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/10 15:37
 */
public class BuidingDo {
    private int id;
    private String name;
    private String address;
    private int sex;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "BuidingDo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                '}';
    }
}
