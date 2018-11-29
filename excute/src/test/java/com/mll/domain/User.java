package com.mll.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author: yifei
 * @Date: 2018/11/22 13:27
 */

@XmlRootElement(name = "User")
public class User {
private int userId;
private String userName;
private String password;
private String birthday;
private double money;

    public User() {
        super();
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthday() {
        return birthday;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", money=" + money +
                '}';
    }
}
