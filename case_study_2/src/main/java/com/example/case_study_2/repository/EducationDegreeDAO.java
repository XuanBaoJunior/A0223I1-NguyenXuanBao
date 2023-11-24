package com.example.case_study_2.repository;

import com.example.case_study_2.model.EducationDegree;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeDAO {
    // Your database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/case_study_final";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";

    // SQL queries
    private static final String SELECT_ALL_EDUCATION_DEGREES = "SELECT * FROM education_degree";
    // Add other queries as needed

    public List<EducationDegree> getAllEducationDegrees() {
        List<EducationDegree> educationDegrees = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_EDUCATION_DEGREES)) {

            while (resultSet.next()) {
                EducationDegree educationDegree = new EducationDegree();
                // Set educationDegree properties based on resultSet
                educationDegrees.add(educationDegree);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }

        return educationDegrees;
    }

    // Add other methods as needed for educationDegree-related database operations
}

