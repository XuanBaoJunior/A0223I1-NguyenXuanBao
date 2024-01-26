package com.example.xe_co.Repository;

import com.example.xe_co.Model.San_xuat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class San_xuatRepository implements ISan_xuatRepository{
    @Override
    public List<San_xuat> findAll() {
        List<San_xuat> list = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection();
             Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery("select * from san_xuat");
            while (resultSet.next()) {
                int id_nuoc_san_xuat = resultSet.getInt("id_nuoc_san_xuat");
                String nuoc_san_xuat = resultSet.getString("nuoc_san_xuat");
                San_xuat san_xuat = new San_xuat(id_nuoc_san_xuat, nuoc_san_xuat);
                list.add(san_xuat);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public San_xuat findIdSX(int id) {
        try(Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from san_xuat where id_nuoc_san_xuat = ?");) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_sx = resultSet.getInt("id_nuoc_san_xuat");
                String ten_sx = resultSet.getString("nuoc_san_xuat");
                San_xuat san_xuat = new San_xuat(id_sx, ten_sx);
                return san_xuat;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<San_xuat> find(int id) {
        List<San_xuat> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from san_xuat where id_nuoc_san_xuat != ?");
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_sx = resultSet.getInt("id_nuoc_san_xuat");
                String ten_sx = resultSet.getString("nuoc_san_xuat");
                San_xuat san_xuat = new San_xuat(id_sx, ten_sx);
                list.add(san_xuat);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public San_xuat findName(String SXname) {
        try(Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from san_xuat where nuoc_san_xuat = ?");) {
            preparedStatement.setString(1, SXname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_sx = resultSet.getInt("id_nuoc_san_xuat");
                String ten_sx = resultSet.getString("nuoc_san_xuat");
                San_xuat san_xuat = new San_xuat(id_sx, ten_sx);
                return san_xuat;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
