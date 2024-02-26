package com.example.baithimd3.Repository;

import com.example.baithimd3.Model.NguoiThue;
import com.example.baithimd3.Model.PhongTro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NguoiThueRepository implements INguoiThueRepository{
    private final String SELECT = "select * from nguoi_thue n join phong_tro p on n.id=p.id";
    private final String DELETE = "delete from nguoi_thue where id_nguoi_thue = ?";
    private final String INSERT = "insert into nguoi_thue(id_nguoi_thue, ten_nguoi_thue, so_dien_thoai, ngay_thue, id) \n" +
            "values (?, ?, ?, ?, ?)";
    private final String UPDATE = "update nguoi_thue set id_nguoi_thue, ten_nguoi_thue = ?, so_dien_thoai = ?, ngay_thue = ?, id = ? where id_loai_xe = ?";
    private final String SEARCH = "SELECT n.*, p.* " +
            "FROM nguoi_thue n " +
            "JOIN phong_tro p ON n.id = p.id " +
            "WHERE n.ten_nguoi_thue LIKE ? OR n.so_dien_thoai LIKE ? OR p.hinh_thuc_thanh_toan LIKE ?";


    @Override
    public List<NguoiThue> display() {
        List<NguoiThue> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                String id_nguoi_thue = resultSet.getString("id_nguoi_thue");
                String ten_nguoi_thue = resultSet.getString("ten_nguoi_thue");
                String so_dien_thoai = resultSet.getString("so_dien_thoai");
                String ngay_thue = resultSet.getString("ngay_thue");
                int id = resultSet.getInt("id");
                String hinh_thuc_thanh_toan = resultSet.getString("hinh_thuc_thanh_toan");
                String ghi_chu = resultSet.getString("ghi_chu");
                PhongTro phongTro = new PhongTro(id, hinh_thuc_thanh_toan, ghi_chu);
                NguoiThue nguoiThue = new NguoiThue(id_nguoi_thue, ten_nguoi_thue, so_dien_thoai, ngay_thue, phongTro);
                list.add(nguoiThue);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void create(NguoiThue nguoiThue) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        ) {
            preparedStatement.setString(1, nguoiThue.getId_nguoi_thue());
            preparedStatement.setString(2, nguoiThue.getTen_nguoi_thue());
            preparedStatement.setString(3, nguoiThue.getSo_dien_thoai());
            preparedStatement.setString(4, nguoiThue.getNgay_thue());
            preparedStatement.setInt(5, nguoiThue.getPhongTro().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public NguoiThue edit(int id) {
        return null;
    }

    @Override
    public void update(NguoiThue nguoiThue) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        ) {
            preparedStatement.setString(1, nguoiThue.getId_nguoi_thue());
            preparedStatement.setString(2, nguoiThue.getTen_nguoi_thue());
            preparedStatement.setString(3, nguoiThue.getSo_dien_thoai());
            preparedStatement.setString(4, nguoiThue.getNgay_thue());
            preparedStatement.setInt(5, nguoiThue.getPhongTro().getId());
            preparedStatement.setString(6, nguoiThue.getId_nguoi_thue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        ) {
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<NguoiThue> searchName(String name) {
        List<NguoiThue> nguoiThueList = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
        ) {
            preparedStatement.setString(1, "%" + name + "%"); // ten_nguoi_thue
            preparedStatement.setString(2, "%" + name + "%"); // so_dien_thoai
            preparedStatement.setString(3, "%" + name + "%"); // hinh_thuc_TT
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id_nguoi_thue = resultSet.getString("id_nguoi_thue");
                String ten_nguoi_thue = resultSet.getString("ten_nguoi_thue");
                String so_dien_thoai = resultSet.getString("so_dien_thoai");
                String ngay_thue = resultSet.getString("ngay_thue");
                int id = resultSet.getInt("id");
                String hinh_thuc_thanh_toan = resultSet.getString("hinh_thuc_thanh_toan");
                String ghi_chu = resultSet.getString("ghi_chu");
                PhongTro phongTro = new PhongTro(id, hinh_thuc_thanh_toan, ghi_chu);
                NguoiThue nguoiThue = new NguoiThue(id_nguoi_thue, ten_nguoi_thue, so_dien_thoai, ngay_thue, phongTro);
                nguoiThueList.add(nguoiThue);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nguoiThueList;
    }
}
