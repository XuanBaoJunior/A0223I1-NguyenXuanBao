package com.example.democar.Repository;

import com.example.democar.Model.San_xuat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class San_xuatRepository implements ISan_xuatRepository {
    private final String SELECT_SX = "select * from San_xuat";
    private final String SELECT_ID = "select * from San_xuat where id = ?";
    private final String SELECT = "select * from San_xuat where id != ?";

    @Override
    public List<San_xuat> findAll() {
        List<San_xuat> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(SELECT_SX);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nuoc_san_xuat = resultSet.getString("nuoc_san_xuat");
                San_xuat san_xuat = new San_xuat(id, nuoc_san_xuat);
                list.add(san_xuat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public San_xuat findIdSX(int id) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idSX = resultSet.getInt("id");
                String nuoc_san_xuat = resultSet.getString("nuoc_san_xuat");
                San_xuat san_xuat = new San_xuat(idSX, nuoc_san_xuat);
                return san_xuat;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<San_xuat> find(int id) {
        List<San_xuat> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idF = resultSet.getInt("id");
                String nuoc_san_xuat = resultSet.getString("nuoc_san_xuat");
                San_xuat san_xuat = new San_xuat(idF, nuoc_san_xuat);
                list.add(san_xuat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
