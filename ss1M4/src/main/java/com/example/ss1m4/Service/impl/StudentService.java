package com.example.ss1m4.Service.impl;

import com.example.ss1m4.Model.Student;
import com.example.ss1m4.Repository.IStudentRepository;
import com.example.ss1m4.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }
}
