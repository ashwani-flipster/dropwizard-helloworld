package com.flipkart.entity;

public class UserLoginEntity {
    public int userId;
    public String password;

    public UserLoginEntity(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public UserLoginEntity() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
