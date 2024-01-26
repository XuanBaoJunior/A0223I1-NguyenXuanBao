package com.example.xe_co.Repository;

import com.example.xe_co.Model.Loai_xe;
import com.example.xe_co.Model.San_xuat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Loai_xeRepository implements ILoai_xeRepository{
    private final String SELECT = "SELECT lx.*, sx.nuoc_san_xuat\n" +
            "FROM loai_xe lx\n" +
            "JOIN san_xuat sx ON lx.id_nuoc_san_xuat = sx.id_nuoc_san_xuat";
    private final String SELECT_EDIT = "SELECT lx.id_loai_xe, lx.ten_loai_xe, lx.gia_xe, lx.nam_san_xuat, sx.id_nuoc_san_xuat, sx.nuoc_san_xuat " +
            "FROM loai_xe lx " +
            "JOIN san_xuat sx ON lx.id_nuoc_san_xuat = sx.id_nuoc_san_xuat " +
            "WHERE lx.id_loai_xe = ?";
    private final String UPDATE = "UPDATE loai_xe SET ten_loai_xe = ?, gia_xe = ?, nam_san_xuat = ?, id_nuoc_san_xuat = ? WHERE id_loai_xe = ?";
    @Override
    public List<Loai_xe> display() {
        List<Loai_xe> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()){
                int id_loai_xe = resultSet.getInt("id_loai_xe");
                String ten_loai_xe = resultSet.getString("ten_loai_xe");
                Double gia_xe = resultSet.getDouble("gia_xe");
                int nam_san_xuat = resultSet.getInt("nam_san_xuat");
                int id_nuoc_san_xuat = resultSet.getInt("id_nuoc_san_xuat");
                String nuoc_san_xuat = resultSet.getString("nuoc_san_xuat");
                San_xuat san_xuat = new San_xuat(id_nuoc_san_xuat, nuoc_san_xuat);
                Loai_xe loai_xe = new Loai_xe(id_loai_xe, ten_loai_xe, gia_xe, nam_san_xuat, san_xuat);
                list.add(loai_xe);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void create(Loai_xe loai_xe) {

    }

    @Override
    public Loai_xe edit(int id_loai_xe) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EDIT);
        ) {
            preparedStatement.setInt(1, id_loai_xe);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_loai_xe_ed = resultSet.getInt("id_loai_xe_ed");
                String ten_loai_xe_ed = resultSet.getString("ten_loai_xe_ed");
                Double gia_xe_ed = resultSet.getDouble("gia_xe_ed");
                int nam_san_xuat_ed = resultSet.getInt("nam_san_xuat_ed");
                int id_nuoc_san_xuat_ed = resultSet.getInt("id_nuoc_san_xuat_ed");
                String nuoc_san_xuat_ed = resultSet.getString("nuoc_san_xuat_ed");
                San_xuat san_xuat = new San_xuat(id_nuoc_san_xuat_ed, nuoc_san_xuat_ed);
                Loai_xe loai_xe = new Loai_xe(id_loai_xe_ed, ten_loai_xe_ed, gia_xe_ed, nam_san_xuat_ed, san_xuat);
                return loai_xe;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Loai_xe loai_xe) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        ){
            preparedStatement.setString(1, loai_xe.getTen_loai_xe());
            preparedStatement.setDouble(2, loai_xe.getGia_xe());
            preparedStatement.setInt(3, loai_xe.getNam_san_xuat());
            preparedStatement.setInt(4, loai_xe.getSan_xuat().getId_nuoc_san_xuat());
            preparedStatement.setInt(5, loai_xe.getId_loai_xe());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
    }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Loai_xe> searchName(String name) {
        return null;
    }
}
