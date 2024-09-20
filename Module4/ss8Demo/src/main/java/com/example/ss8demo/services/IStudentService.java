package com.example.ss8demo.services;

import com.example.ss8demo.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    List<Student> findAllByName(String name);

    Page<Student> findAllByName(String name, Pageable pageable);

    void deleteById(Integer code);
}
