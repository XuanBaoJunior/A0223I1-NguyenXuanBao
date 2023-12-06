package com.example.hospital_management.repository;

import com.example.hospital_management.model.Patient;

import java.util.List;

public interface IPatientRepository {
    List<Patient> findAll();

    Patient findIdPatient(int id);

    List<Patient> find(int id);

    Patient findNamePatient(String patientName);
}
