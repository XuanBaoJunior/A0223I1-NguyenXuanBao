package com.example.ss8demo.services.impl;

import com.example.ss8demo.models.Classroom;
import com.example.ss8demo.repositories.IClassroomRepository;
import com.example.ss8demo.services.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService {

    @Autowired
    private IClassroomRepository classroomRepository;

    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }
}
