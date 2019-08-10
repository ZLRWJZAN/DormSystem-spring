package com.ps.dorm.domain;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/13 11:00
 */
public class LoginDo {
    private String number;
    private String password;
    private String code;
    private String mailCode;

    public LoginDo(){

    }
    public LoginDo(String number, String password, String code, String mailCode) {
        this.number = number;
        this.password = password;
        this.code = code;
        this.mailCode = mailCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMailCode() {
        return mailCode;
    }

    public void setMailCode(String mailCode) {
        this.mailCode = mailCode;
    }

    @Override
    public String toString() {
        return "LoginDo{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", mailCode='" + mailCode + '\'' +
                '}';
    }
}
