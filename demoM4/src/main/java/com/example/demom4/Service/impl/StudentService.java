package com.example.demom4.Service.impl;

import com.example.demom4.Model.Student;
import com.example.demom4.Repository.IStudentRepository;
import com.example.demom4.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
