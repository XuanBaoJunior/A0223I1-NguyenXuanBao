package com.example.case_study_2.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseService {
    // Your database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/case_study_final";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}

