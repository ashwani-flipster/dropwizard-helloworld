package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {

    private static Connection connection = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/CRSDatabase";

    //  Database credentials
    static final String USER = "root";

    static final String PASS = "Blue_176486";

    public static Connection getConnection() {

        if (connection != null)
            return connection;
        else {
            try {

                // Step 3 Regiater Driver here and create connection

                Class.forName("com.mysql.jdbc.Driver");

                // Step 4 make/open  a connection

                System.out.println("Connecting to database...");
                connection = DriverManager.getConnection(DB_URL,USER,PASS);


//                Properties prop = new Properties();
//                InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("config.properties");
//                prop.load(inputStream);
//                String driver = prop.getProperty("driver");
//                String url = prop.getProperty("url");
//                String user = prop.getProperty("root");
//                String password = prop.getProperty("password");
//                Class.forName(driver);
//                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }


}
