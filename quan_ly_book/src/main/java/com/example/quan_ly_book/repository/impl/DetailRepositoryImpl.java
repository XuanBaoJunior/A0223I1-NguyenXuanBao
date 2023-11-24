package com.example.quan_ly_book.repository.impl;

import com.example.quan_ly_book.model.Detail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DetailRepositoryImpl implements DetailRepository{
    private static final String CREATE = "INSERT INTO detail (id_book, id_student)\n" +
            "VALUES (?,?);";
    @Override
    public List<Detail> findAll() {
        return null;
    }

    @Override
    public void create(Detail detail) {
        try(Connection connection = BaseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);) {
            preparedStatement.setInt(1,detail.getId_book());
            preparedStatement.setInt(2,detail.getId_student());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Detail detail) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Detail findById(int id) {
        return null;
    }
}
