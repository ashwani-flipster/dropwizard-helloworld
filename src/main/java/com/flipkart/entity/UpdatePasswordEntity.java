package com.flipkart.entity;

public class UpdatePasswordEntity {
    public String newPassword;
    public String oldPassword;
    public int userId;

    public UpdatePasswordEntity() {
    }

    public UpdatePasswordEntity(String newPassword, String oldPassword, int userId) {
        this.newPassword = newPassword;
        this.oldPassword = oldPassword;
        this.userId = userId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
