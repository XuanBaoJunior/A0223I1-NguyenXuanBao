package com.example.benh_an.Repository;

import com.example.benh_an.Model.Benh_an;
import com.example.benh_an.Model.Benh_nhan;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Benh_anRepository implements IBenh_anRepository{
    private final String SELECT = "SELECT ba.id_benh_an, ba.ngay_nhap_vien, ba.ngay_ra_vien, ba.ly_do, bn.id_benh_nhan, bn.ten_benh_nhan " +
            "FROM benh_an ba " +
            "JOIN benh_nhan bn " +
            "ON ba.id_benh_nhan = bn.id_benh_nhan;";
    private final String INSERT = "insert into benh_an(id_benh_an, ngay_nhap_vien, ngay_ra_vien, ly_do, id_benh_nhan) values (?,?,?,?,?)";
    @Override
    public List<Benh_an> display() {
        List<Benh_an> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()){
                String id_benh_an = resultSet.getString("id_benh_an");
                Date ngay_nhap_vien = resultSet.getDate("ngay_nhap_vien");
                Date ngay_ra_vien = resultSet.getDate("ngay_ra_vien");
                String ly_do = resultSet.getString("ly_do");
                String id_benh_nhan = resultSet.getString("id_benh_nhan");
                String ten_benh_nhan = resultSet.getString("ten_benh_nhan");
                Benh_nhan benh_nhan = new Benh_nhan(id_benh_nhan, ten_benh_nhan);
                Benh_an benh_an = new Benh_an(id_benh_an, ngay_nhap_vien, ngay_ra_vien, ly_do, benh_nhan);
                list.add(benh_an);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Boolean create(Benh_an benh_an) {
        String newIDBAn = createNewID1(benh_an);
        benh_an.setId_benh_an(newIDBAn);
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        ) {
            preparedStatement.setString(1, benh_an.getId_benh_an());
            preparedStatement.setDate(2, (java.sql.Date) benh_an.getNgay_nhap_vien());
            preparedStatement.setDate(3, (java.sql.Date) benh_an.getNgay_ra_vien());
            preparedStatement.setString(4, benh_an.getLy_do());
            preparedStatement.setString(5, benh_an.getBenh_nhan().getId_benh_nhan());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public String createShow(String idBenhNhan) {
        return null;
    }

    @Override
    public String createNewID1(Benh_an benh_an) {
        Integer newID =0;
        String tmpBAn ="";
        Integer tmpID;
        String getIDBenhAn= "select id_benh_an from benh_an where id_benh_nhan = " + benh_an.getBenh_nhan().getId_benh_nhan();
        try (
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(getIDBenhAn);
            while (resultSet.next()){
                tmpBAn=resultSet.getString("id_benh_an");
                tmpID= Integer.parseInt(tmpBAn.substring(2,4));
                if(newID< tmpID){
                    newID =tmpID;
                    tmpID=0;
                }
            }
            return  "BA" + newID;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
