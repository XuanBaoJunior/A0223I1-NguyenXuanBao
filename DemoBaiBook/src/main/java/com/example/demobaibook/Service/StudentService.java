package com.example.demobaibook.Service;

import com.example.demobaibook.Model.Student;
import com.example.demobaibook.Repository.IStudentRepository;
import com.example.demobaibook.Repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public List<Student> listStudent() {
        return iStudentRepository.listStudent();
    }
}
