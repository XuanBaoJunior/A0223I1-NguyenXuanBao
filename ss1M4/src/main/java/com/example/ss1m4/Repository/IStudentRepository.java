package com.example.ss1m4.Repository;

import com.example.ss1m4.Model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
