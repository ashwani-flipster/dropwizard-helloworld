package com.flipkart.bean;

public class Notification {
    public int notificationId;
    public int studentId;

    // type of notification
    public int notificationSignature;

    public String message;

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getNotificationSignature() {
        return notificationSignature;
    }

    public void setNotificationSignature(int notificationSignature) {
        this.notificationSignature = notificationSignature;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
