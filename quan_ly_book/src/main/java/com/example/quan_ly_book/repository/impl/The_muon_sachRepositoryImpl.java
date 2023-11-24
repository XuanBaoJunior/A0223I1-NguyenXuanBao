package com.example.quan_ly_book.repository.impl;

import com.example.quan_ly_book.model.Book;
import com.example.quan_ly_book.model.Student;
import com.example.quan_ly_book.model.The_muon_sach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class The_muon_sachRepositoryImpl implements The_muon_sachRepository{
    private static final String FINDID = "SELECT * FROM the_muon_sach WHERE ma_muon = ?";
    private static final String FINDALL = "SELECT * FROM the_muon_sach";
    private static final String DELETE = "DELETE FROM the_muon_sach WHERE ma_muon = ?";
    private static final String CREATE = "INSERT INTO the_muon_sach (ma_muon, trang_thai, ngay_muon, ngay_tra, id_book, id_student)\n" +
            "VALUES (?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE the_muon_sach SET trang_thai = ? ,ngay_muon = ?, ngay_tra = ?, id_book = ?, id_student = ? where ma_muon = ?;";

    private StudentRepository studentRepository = new StudentRepositoryImpl();
    private BookRepository bookRepository = new BookRepositoryImpl();
    @Override
    public List<The_muon_sach> findAll() {
        List<The_muon_sach> theMuonSachList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectionJavaToDB();
            PreparedStatement statement = connection.prepareStatement(FINDALL);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
               String ma_muon =  resultSet.getString("ma_muon");
               String trang_thai = resultSet.getString("trang_thai");
                java.sql.Date ngay_muon = resultSet.getDate("ngay_muon");
                java.sql.Date ngayTra = resultSet.getDate("ngay_tra");
                int bookSQL = resultSet.getInt("id_book");
                Book book = bookRepository.findById(bookSQL);
                int studentSQL = resultSet.getInt("id_student");
                Student student = studentRepository.findById(studentSQL);

                The_muon_sach the_muon_sach = new The_muon_sach(ma_muon,trang_thai,ngay_muon,ngayTra,book,student);

                theMuonSachList.add(the_muon_sach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theMuonSachList;
    }

    @Override
    public void create(The_muon_sach the_muon_sach) {
        try(Connection connection = BaseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);) {
            preparedStatement.setString(1,the_muon_sach.getMa_muon());
            preparedStatement.setString(2,the_muon_sach.getTrang_thai());
            Date DateSQLMuon = new Date(the_muon_sach.getNgay_muon().getTime());
            preparedStatement.setDate(3, DateSQLMuon);
            Date DateSQLTra = new Date(the_muon_sach.getNgay_tra().getTime());
            preparedStatement.setDate(4, DateSQLTra);
            preparedStatement.setInt(5,the_muon_sach.getBook().getId_book());
            preparedStatement.setInt(6,the_muon_sach.getStudent().getId_student());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(The_muon_sach the_muon_sach) {
        try(Connection connection = BaseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);) {
            preparedStatement.setString(1,the_muon_sach.getTrang_thai());
//            preparedStatement.setDate(2, (Date) the_muon_sach.getNgay_muon());
//            preparedStatement.setDate(3, (Date) the_muon_sach.getNgay_tra());
            preparedStatement.setDate(2, new Date(the_muon_sach.getNgay_muon().getTime()));
            preparedStatement.setDate(3, new Date(the_muon_sach.getNgay_tra().getTime()));
            preparedStatement.setInt(4,the_muon_sach.getBook().getId_book());
            preparedStatement.setInt(5,the_muon_sach.getStudent().getId_student());
            preparedStatement.setString(6,the_muon_sach.getMa_muon());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String id) {
        Connection connection = null;
        try {
            connection = BaseRepository.getConnectionJavaToDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public The_muon_sach findById(int id) {

        return null;
    }

    @Override
    public The_muon_sach findByIDSach(String id,String bookId, String studentId) {
        The_muon_sach the_muon_sach = null;
        try {
            Connection connection = BaseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                the_muon_sach = new The_muon_sach();
                the_muon_sach.setMa_muon(resultSet.getString(1));
                the_muon_sach.setTrang_thai(resultSet.getString(2));
                the_muon_sach.setNgay_muon(resultSet.getDate(3));
                the_muon_sach.setNgay_tra(resultSet.getDate(4));


                Book book = bookRepository.findById(Integer.parseInt(bookId));
                the_muon_sach.setBook(book);

                Student student = studentRepository.findById(Integer.parseInt(studentId));
                the_muon_sach.setStudent(student);

            }
            return the_muon_sach;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
