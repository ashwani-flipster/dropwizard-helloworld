package com.dropwizard.dao;

import com.dropwizard.constants.SQLQueriesConstants;
import com.dropwizard.exceptions.NotificationNotSentException;
import com.dropwizard.exceptions.PaymentAlreadyExistsException;
import com.dropwizard.exceptions.PaymentUnsuccessfulException;
import com.dropwizard.exceptions.RegistrationUnsuccessfulException;
import com.dropwizard.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NotificationDAOoperation implements NotificationDAO{

    private PreparedStatement statement = null;

    public void sendNotification(int userId, int type) throws SQLException, NotificationNotSentException {
        Connection connection = DBConnection.getConnection();

        try {
            String sql = SQLQueriesConstants.SEND_NOTIFICATION;
            statement=connection.prepareStatement(sql);
            statement.setInt(1, userId);

            String message = "";
            switch (type) {
                case 1:
                    message = "Notification: Payment Successful.";
                    break;
                case 2:
                    message = "Notification: Registration Successful.";
                    break;
                case 3:
                    message = "";
                    break;
            }

            statement.setString(2, message);
            statement.setInt(3, type);

            statement.executeUpdate();

        } catch (SQLException se) {
            System.out.println(se.getMessage());
            throw new NotificationNotSentException();
        }
    }
}
