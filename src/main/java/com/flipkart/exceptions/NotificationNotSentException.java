package com.flipkart.exceptions;

public class NotificationNotSentException extends Exception {
    @Override
    public String getMessage() {
        return "Notification cannot be sent";
    }
}
