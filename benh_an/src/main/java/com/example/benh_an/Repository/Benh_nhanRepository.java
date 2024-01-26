package com.example.benh_an.Repository;

import com.example.benh_an.Model.Benh_nhan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Benh_nhanRepository implements IBenh_nhanRepository{
    private final String SELECT_BN = "select * from benh_nhan";
    @Override
    public List<Benh_nhan> findAll() {
        List<Benh_nhan> list = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection();
             Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery(SELECT_BN);
            while (resultSet.next()){
                String id_benh_nhan = resultSet.getString("id_benh_nhan");
                String ten_benh_nhan = resultSet.getString("ten_benh_nhan");
                Benh_nhan benh_nhan = new Benh_nhan(id_benh_nhan, ten_benh_nhan);
                list.add(benh_nhan);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public String getNameBN(String id_benh_nhan) {
        String SELECT_TEN_BN = "select ten_benh_nhan from benh_nhan where id_benh_nhan = '" + id_benh_nhan + "'";
        String get_ten =null;
        try (Connection connection = BaseRepository.getConnection();
             Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery(SELECT_TEN_BN);
            while (resultSet.next()){
                get_ten = resultSet.getString("id_benh_nhan");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return get_ten;
    }
}
