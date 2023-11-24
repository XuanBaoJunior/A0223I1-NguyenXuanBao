package com.example.demo_category.Repository;

import com.example.demo_category.Model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository{
    private final String SELECT_CATEGORY = "select * from category";
    private final String SELECT_ID = "select * from category where id_category = ?";
    private final String SELECT = "select * from category where id_category != ?";

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(SELECT_CATEGORY);
            while (resultSet.next()) {
                int id_category = resultSet.getInt("id_category");
                String type_category = resultSet.getString("type_category");
                Category category = new Category(id_category, type_category);
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Category findIdCategory(int id) {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_category = resultSet.getInt("id_category");
                String type_category = resultSet.getString("type_category");
                Category category = new Category(id_category, type_category);
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> find(int id) {
        List<Category> list = new ArrayList<>();
        try
                (Connection connection = BaseRepository.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_category = resultSet.getInt("id_category");
                String type_category = resultSet.getString("type_category");
                Category category = new Category(id_category, type_category);
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
