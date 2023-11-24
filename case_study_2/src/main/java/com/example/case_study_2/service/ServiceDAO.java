package com.example.case_study_2.service;

import com.example.case_study_2.model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {
    // Your database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/case_study_final";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";

    // SQL queries
    private static final String SELECT_ALL_SERVICES = "SELECT * FROM service";
    // Add other queries as needed

    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SERVICES)) {

            while (resultSet.next()) {
                Service service = new Service();
                // Set service properties based on resultSet
                services.add(service);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }

        return services;
    }

    // Add other methods as needed for service-related database operations
}

