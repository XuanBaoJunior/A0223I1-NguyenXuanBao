package com.example.democar.Repository;

import com.example.democar.Model.Loai_xe;
import com.example.democar.Model.San_xuat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Loai_xeRepository implements ILoai_xeRepository{
    private final String SELECT = "select * from Loai_xe l join San_xuat s on l.id=s.id";
    private final String INSERT = "insert into Loai_xe(name, gia_xe, nam_san_xuat, color, mota, id) \n" +
            "values (?, ?, ?, ?, ?, ?)";
    private final String SELECT_PRODUCT = "select l.*, s.nuoc_san_xuat from Loai_xe l join San_xuat s on l.id=s.id where l.id_loai_xe=?";
    private final String UPDATE = "update Loai_xe set name = ?, gia_xe = ?, nam_san_xuat = ?, color = ?, mota = ?, id = ? where id_loai_xe = ?";
    private final String DELETE = "delete from Loai_xe where id_loai_xe = ?";
    private final String SEARCH_NAME = "select l.*, s.nuoc_san_xuat from Loai_xe l join San_xuat s on l.id=s.id where l.name like ?";
    @Override
    public List<Loai_xe> display() {
        List<Loai_xe> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                int id_loai_xe = resultSet.getInt("id_loai_xe");
                String name = resultSet.getString("name");
                Double gia_xe = resultSet.getDouble("gia_xe");
                int nam_san_xuat = resultSet.getInt("nam_san_xuat");
                String color = resultSet.getString("color");
                String mota = resultSet.getString("mota");
                int id = resultSet.getInt("id");
                String nuoc_san_xuat = resultSet.getString("nuoc_san_xuat");
                San_xuat san_xuat = new San_xuat(id, nuoc_san_xuat);
                Loai_xe loai_xe = new Loai_xe(id_loai_xe, name, gia_xe, nam_san_xuat, color, mota, san_xuat);
                list.add(loai_xe);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void create(Loai_xe loai_xe) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        ) {
            preparedStatement.setString(1, loai_xe.getName());
            preparedStatement.setDouble(2, loai_xe.getGia_xe());
            preparedStatement.setInt(3, loai_xe.getNam_san_xuat());
            preparedStatement.setString(4, loai_xe.getColor());
            preparedStatement.setString(5, loai_xe.getMota());
            preparedStatement.setInt(6, loai_xe.getSan_xuat().getId_san_xuat());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Loai_xe edit(int id) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_loai_xe = resultSet.getInt("id_loai_xe");
                String name = resultSet.getString("name");
                Double gia_xe = resultSet.getDouble("gia_xe");
                int nam_san_xuat = resultSet.getInt("nam_san_xuat");
                String color = resultSet.getString("color");
                String mota = resultSet.getString("mota");
                int id2 = resultSet.getInt("id");
                String nuoc_san_xuat = resultSet.getString("nuoc_san_xuat");
                San_xuat san_xuat = new San_xuat(id2, nuoc_san_xuat);
                Loai_xe loai_xe = new Loai_xe(id_loai_xe, name, gia_xe, nam_san_xuat, color, mota, san_xuat);
                return loai_xe;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Loai_xe loai_xe) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        ) {
            preparedStatement.setString(1, loai_xe.getName());
            preparedStatement.setDouble(2, loai_xe.getGia_xe());
            preparedStatement.setInt(3, loai_xe.getNam_san_xuat());
            preparedStatement.setString(4, loai_xe.getColor());
            preparedStatement.setString(5, loai_xe.getMota());
            preparedStatement.setInt(6, loai_xe.getSan_xuat().getId_san_xuat());
            preparedStatement.setInt(7, loai_xe.getId_loai_xe());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Loai_xe> searchName(String name) {
        List<Loai_xe> loaiXeList = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME);
        ) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_loai_xe = resultSet.getInt("id_loai_xe");
                String nameLoaiXe = resultSet.getString("name");
                Double gia_xe = resultSet.getDouble("gia_xe");
                int nam_san_xuat = resultSet.getInt("nam_san_xuat");
                String color = resultSet.getString("color");
                String mota = resultSet.getString("mota");
                int id = resultSet.getInt("id");
                String nuoc_san_xuat = resultSet.getString("nuoc_san_xuat");
                San_xuat san_xuat = new San_xuat(id, nuoc_san_xuat);
                Loai_xe loai_xe = new Loai_xe(id_loai_xe, nameLoaiXe, gia_xe, nam_san_xuat, color, mota, san_xuat);
                loaiXeList.add(loai_xe);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loaiXeList;
    }
}
