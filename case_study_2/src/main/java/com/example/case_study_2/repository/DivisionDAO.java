package com.example.case_study_2.repository;

import com.example.case_study_2.model.Division;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivisionDAO {
    // Your database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/case_study_final";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";

    // SQL queries
    private static final String SELECT_ALL_DIVISIONS = "SELECT * FROM division";
    // Add other queries as needed

    public List<Division> getAllDivisions() {
        List<Division> divisions = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_DIVISIONS)) {

            while (resultSet.next()) {
                Division division = new Division();
                // Set division properties based on resultSet
                divisions.add(division);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }

        return divisions;
    }

    // Add other methods as needed for division-related database operations
}

