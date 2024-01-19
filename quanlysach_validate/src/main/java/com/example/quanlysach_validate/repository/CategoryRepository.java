package com.example.quanlysach_validate.repository;

import com.example.quanlysach_validate.model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository{
    private final String SELECT_CATEGORY = "select * from Category";
    private final String SELECT_ID = "select * from Category where id = ?";
    private final String SELECT = "select * from Category where id != ?";
    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();

        try(
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(SELECT_CATEGORY);
            while (resultSet.next()){
                int id_category = resultSet.getInt("id_category");
                String type = resultSet.getString("type");
                Category category = new Category(id_category, type);
                list.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Category findIdCategory(int id) {
        return null;
    }

    @Override
    public List<Category> find(int id) {
        return null;
    }
}
