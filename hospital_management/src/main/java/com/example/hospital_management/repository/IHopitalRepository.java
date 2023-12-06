package com.example.hospital_management.repository;

import com.example.hospital_management.model.Hopital;

import java.util.List;

public interface IHopitalRepository {
    List<Hopital> display();

    void create(Hopital hopital);

    Hopital edit(int id);

    void update(Hopital hopital);

    void delete(int id);

    List<Hopital> searchNamePatient(String name);
}
