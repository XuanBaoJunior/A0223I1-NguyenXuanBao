package com.example.demom4.Repository;

import com.example.demom4.Model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
