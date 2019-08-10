package com.ps.dorm.domain;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/10 15:41
 */
public class DormDo {
    private int id;
    private int number;
    private String buidingName;
    private int currentPeople;
    private int maxPeople;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBuidingName() {
        return buidingName;
    }

    public void setBuidingName(String buidingName) {
        this.buidingName = buidingName;
    }

    public int getCurrentPeople() {
        return currentPeople;
    }

    public void setCurrentPeople(int currentPeople) {
        this.currentPeople = currentPeople;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }
}
