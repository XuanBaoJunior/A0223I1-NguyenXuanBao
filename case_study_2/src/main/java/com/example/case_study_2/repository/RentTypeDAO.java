package com.example.case_study_2.repository;

import com.example.case_study_2.model.RentType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentTypeDAO {
    // Your database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/case_study_final";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";

    // SQL queries
    private static final String SELECT_ALL_RENT_TYPES = "SELECT * FROM rent_type";
    // Add other queries as needed

    public List<RentType> getAllRentTypes() {
        List<RentType> rentTypes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_RENT_TYPES)) {

            while (resultSet.next()) {
                RentType rentType = new RentType();
                // Set rentType properties based on resultSet
                rentTypes.add(rentType);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }

        return rentTypes;
    }

    // Add other methods as needed for rentType-related database operations
}

