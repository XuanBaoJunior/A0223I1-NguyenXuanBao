package com.example.quan_ly_book.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String JDBCURL = "jdbc:mysql://localhost:3306/quan_ly_sach";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            // Handle the ClassNotFoundException appropriately (e.g., log it)
            e.printStackTrace();
            throw new RuntimeException("Failed to load JDBC driver. Check your classpath.");
        } catch (SQLException e) {
            // Handle the SQLException appropriately (e.g., log it)
            e.printStackTrace();
            throw new RuntimeException("Failed to establish a database connection.");
        }
    }

    private BaseRepository() {
        // private constructor to prevent instantiation
    }

    public static Connection getConnectionJavaToDB() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
        }
        return connection;
    }
}
//public class BaseRepository {
//    private static final String JDBCURL = "jdbc:mysql://localhost:3306/quan_ly_sach";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "123456";
//    private static Connection connection;
//
//    static {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private BaseRepository() {
//
//    }
//
//    public static Connection getConnectionJavaToDB() {
//        return connection;
//    }
//}
