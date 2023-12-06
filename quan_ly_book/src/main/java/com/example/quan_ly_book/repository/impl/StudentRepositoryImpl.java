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

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(String id) {

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
