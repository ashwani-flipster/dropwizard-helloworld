package com.flipkart.dao;

import com.flipkart.exceptions.NotificationNotSentException;

import java.sql.SQLException;

public interface NotificationDAO {
    public void sendNotification(int userId, int type) throws SQLException, NotificationNotSentException;
}
