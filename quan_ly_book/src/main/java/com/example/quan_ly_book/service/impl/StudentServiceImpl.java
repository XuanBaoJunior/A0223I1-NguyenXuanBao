package com.example.quan_ly_book.service.impl;

import com.example.quan_ly_book.model.Student;
import com.example.quan_ly_book.repository.impl.StudentRepository;
import com.example.quan_ly_book.repository.impl.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void create(Student object) {

    }

    @Override
    public void update(Student object) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }
}
