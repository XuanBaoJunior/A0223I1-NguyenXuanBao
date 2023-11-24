package com.example.case_study_2.service;

import com.example.case_study_2.model.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDAO {
    // Your database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/case_study_final";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";

    // SQL queries
    private static final String SELECT_ALL_CONTRACTS = "SELECT * FROM contract";
    // Add other queries as needed

    public List<Contract> getAllContracts() {
        List<Contract> contracts = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_CONTRACTS)) {

            while (resultSet.next()) {
                Contract contract = new Contract();
                // Set contract properties based on resultSet
                contracts.add(contract);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }

        return contracts;
    }

    // Add other methods as needed for contract-related database operations
}

