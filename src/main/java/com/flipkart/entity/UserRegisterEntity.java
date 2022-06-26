package com.flipkart.entity;

public class UserRegisterEntity {
    public String name;
    public String password;

    public UserRegisterEntity() {
    }

    public UserRegisterEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
