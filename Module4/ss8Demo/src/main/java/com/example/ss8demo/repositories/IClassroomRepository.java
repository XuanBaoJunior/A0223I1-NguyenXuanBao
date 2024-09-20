package com.example.ss8demo.repositories;

import com.example.ss8demo.models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassroomRepository extends JpaRepository<Classroom, Integer> {
}
