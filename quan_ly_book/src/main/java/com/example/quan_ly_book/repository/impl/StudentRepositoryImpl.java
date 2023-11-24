package com.example.quan_ly_book.repository.impl;

import com.example.quan_ly_book.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{
    private static final String FINDID = "SELECT * FROM student WHERE id_student = ?";
    private static final String FINDALL = "SELECT * FROM student";
    private static final String DELETE = "DELETE FROM student WHERE id_student = ?";
    private static final String CREATE = "INSERT INTO student (name_student, class_student)\n" +
            "VALUES (?,?);";
    private static final String UPDATE = "UPDATE BOOK SET name_student = ? ,class_student = ? where id_student = ?;";
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try {
            Statement statement = BaseRepository.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery(FINDALL);
            while (resultSet.next()){
                Student student = new Student();
                student.setId_student(resultSet.getInt(1));
                student.setName_student(resultSet.getString(2));
                student.setClass_student(resultSet.getString(3));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void create(Student student) {
//        try(Connection connection = BaseRepository.getConnectionJavaToDB();
//            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);) {
//            preparedStatement.setString(1,student.getName_student());
//            preparedStatement.setString(2,student.getClass_student());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void update(Student student) {
//        try(Connection connection = BaseRepository.getConnectionJavaToDB();
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);) {
//            preparedStatement.setString(1,student.getName_student());
//            preparedStatement.setString(2,student.getClass_student());
//            preparedStatement.setInt(3, student.getId_student());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void delete(String id) {
//        Connection connection = BaseRepository.getConnectionJavaToDB();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
//            preparedStatement.setString(1,id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        try {
            Connection connection = BaseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

//                student.setId_student(resultSet.getInt(1));
//                student.setName_student(resultSet.getString(2));
//                student.setClass_student(resultSet.getString(3));
                String nameStudent = resultSet.getString("name_student");
                String classStudent = resultSet.getString("class_student");
                student = new Student(id,nameStudent,classStudent);
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
