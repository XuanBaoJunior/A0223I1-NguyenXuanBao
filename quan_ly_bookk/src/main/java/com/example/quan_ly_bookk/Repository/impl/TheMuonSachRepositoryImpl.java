package com.example.quan_ly_bookk.Repository.impl;

import com.example.quan_ly_bookk.DTO.TheMuonSachDTO;
import com.example.quan_ly_bookk.Model.TheMuonSach;
import com.example.quan_ly_bookk.Repository.TheMuonSachRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheMuonSachRepositoryImpl implements TheMuonSachRepository {
    private static final String CALLBYMN = "call search_by_ma_muon(?)";
    private static final String FINDID = "SELECT * FROM the_muon_sach WHERE ma_muon = ?";
    //private static final String FINDALL = "SELECT * FROM the_muon_sach";
    private static final String FINDALL = "select ma_muon,trang_thai,ngay_muon,ngay_tra,name_book,name_student \n" +
            "from the_muon_sach\n" +
            " inner join book \n" +
            " on the_muon_sach.id_book = book.id_book\n" +
            " inner join student \n" +
            " on the_muon_sach.id_student = student.id_student";

    private static final String DELETE = "DELETE FROM the_muon_sach WHERE ma_muon = ?";
    private static final String CREATE = "INSERT INTO the_muon_sach (ma_muon, trang_thai, ngay_muon, ngay_tra)\n" +
            "VALUES (?,?,?,?);";
    private static final String UPDATE = "UPDATE BOOK SET trang_thai = ? ,ngay_muon = ?, ngay_tra = ? where ma_muon = ?;";
    @Override
    public List<TheMuonSachDTO> findAll() {
        List<TheMuonSachDTO> theMuonSachList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery(FINDALL);
            while (resultSet.next()){
                TheMuonSachDTO theMuonSachDTO = new TheMuonSachDTO();
                theMuonSachDTO.setMa_muon(resultSet.getString("ma_muon"));
                theMuonSachDTO.setTrang_thai(resultSet.getString("trang_thai"));
                theMuonSachDTO.setNgay_muon(resultSet.getDate("ngay_muon"));
                theMuonSachDTO.setNgay_tra(resultSet.getDate("ngay_tra"));
                theMuonSachDTO.setName_book(resultSet.getString("name_book"));
                theMuonSachDTO.setName_student(resultSet.getString("name_student"));
                theMuonSachList.add(theMuonSachDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theMuonSachList;
    }

    @Override
    public void create(TheMuonSach book) {
        try(Connection connection = BaseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);) {
            preparedStatement.setString(1,book.getMa_muon());
            preparedStatement.setString(2,book.getTrang_thai());
            preparedStatement.setDate(3, (Date) book.getNgay_muon());
            preparedStatement.setDate(4, (Date) book.getNgay_muon());
            preparedStatement.setInt(5, book.getId_book());
            preparedStatement.setInt(6, book.getId_student());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TheMuonSach book) {

    }

    @Override
    public void delete(String id) {
        Connection connection = BaseRepository.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TheMuonSachDTO> findById(String id) {
        List<TheMuonSachDTO> theMuonSachDTOList = new ArrayList<>();
        try {
            CallableStatement callableStatement = BaseRepository.getConnectionJavaToDB().prepareCall(CALLBYMN);
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                TheMuonSachDTO theMuonSachDTO = new TheMuonSachDTO();
                theMuonSachDTO.setMa_muon(resultSet.getString("ma_muon"));
                theMuonSachDTO.setTrang_thai(resultSet.getString("trang_thai"));
                theMuonSachDTO.setNgay_muon(resultSet.getDate("ngay_muon"));
                theMuonSachDTO.setNgay_tra(resultSet.getDate("ngay_tra"));
                theMuonSachDTO.setName_book(resultSet.getString("name_book"));
                theMuonSachDTO.setName_student(resultSet.getString("name_student"));
                theMuonSachDTOList.add(theMuonSachDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theMuonSachDTOList;
    }

}
