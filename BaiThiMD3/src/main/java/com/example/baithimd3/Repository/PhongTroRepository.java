package com.example.baithimd3.Repository;

import com.example.baithimd3.Model.PhongTro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongTroRepository implements IPhongTroRepository{
    private final String SELECT_PT = "select * from phong_tro";
    private final String SELECT_ID = "select * from phong_tro where id = ?";
    private final String SELECT = "select * from phong_tro where id != ?";
    @Override
    public List<PhongTro> findAll() {
        List<PhongTro> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(SELECT_PT);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String hinh_thuc_thanh_toan = resultSet.getString("hinh_thuc_thanh_toan");
                String ghi_chu = resultSet.getString("ghi_chu");
                PhongTro phongTro = new PhongTro(id, hinh_thuc_thanh_toan, ghi_chu);
                list.add(phongTro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public PhongTro findIdPT(String id) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);
        ) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idT = resultSet.getInt("id");
                String hinh_thuc_thanh_toan = resultSet.getString("hinh_thuc_thanh_toan");
                String ghi_chu = resultSet.getString("ghi_chu");
                PhongTro phongTro = new PhongTro(idT, hinh_thuc_thanh_toan, ghi_chu);
                return phongTro;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<PhongTro> find(String id) {
        List<PhongTro> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
        ) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idPT = resultSet.getInt("id");
                String hinh_thuc_thanh_toan = resultSet.getString("hinh_thuc_thanh_toan");
                String ghi_chu = resultSet.getString("ghi_chu");
                PhongTro phongTro = new PhongTro(idPT, hinh_thuc_thanh_toan, ghi_chu);
                list.add(phongTro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
