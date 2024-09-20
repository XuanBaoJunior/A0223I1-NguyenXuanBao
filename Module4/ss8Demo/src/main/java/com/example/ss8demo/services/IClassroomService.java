package com.example.ss8demo.services;


import com.example.ss8demo.models.Classroom;

import java.util.List;

public interface IClassroomService {
    List<Classroom> findAll();
}
