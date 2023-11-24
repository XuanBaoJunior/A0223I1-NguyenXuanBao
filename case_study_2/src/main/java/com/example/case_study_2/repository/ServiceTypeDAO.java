package com.example.case_study_2.repository;

import com.example.case_study_2.model.ServiceType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeDAO {
    // Your database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/case_study_final";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";

    // SQL queries
    private static final String SELECT_ALL_SERVICE_TYPES = "SELECT * FROM service_type";
    // Add other queries as needed

    public List<ServiceType> getAllServiceTypes() {
        List<ServiceType> serviceTypes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SERVICE_TYPES)) {

            while (resultSet.next()) {
                ServiceType serviceType = new ServiceType();
                // Set serviceType properties based on resultSet
                serviceTypes.add(serviceType);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }

        return serviceTypes;
    }

    // Add other methods as needed for serviceType-related database operations
}
