package com.example.case_study_2.service;

import com.example.case_study_2.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService extends BaseService {
    // SQL queries
    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customer";
    // Add other queries as needed

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_CUSTOMERS)) {

            while (resultSet.next()) {
                Customer customer = new Customer();
                // Set customer properties based on resultSet
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }

        return customers;
    }

    // Add other methods as needed for customer-related business logic
}

