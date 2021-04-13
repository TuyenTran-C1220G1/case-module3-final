package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hotelmanager";
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "123456";
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}