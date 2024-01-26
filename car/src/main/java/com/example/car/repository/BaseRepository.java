package com.example.car.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/car";
    private static String username = "root";
    private static String password = "123456";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BaseRepository() {
    }

    public static Connection getConnectionJavaToDB() {
        return connection;

    }
}
