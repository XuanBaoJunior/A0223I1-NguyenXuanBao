package com.example.hospital_management.repository;

import com.example.hospital_management.model.Patient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientRepositoryImpl implements IPatientRepository{
    private final String SELECT_CATEGORY = "select * from Category";
    private final String SELECT_ID = "select * from Category where id = ?";
    private final String SELECT = "select * from Category where id != ?";

    @Override
    public List<Patient> findAll() {
        List<Patient> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(SELECT_CATEGORY);
            while (resultSet.next()){
                int id_patient = resultSet.getInt("id_patient");
                String name_patient = resultSet.getString("name_patient");
                int age_patient = resultSet.getInt("age_patient");
                Patient patient = new Patient(id_patient, name_patient, age_patient);
                list.add(patient);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Patient findIdPatient(int id) {
        return null;
    }

    @Override
    public List<Patient> find(int id) {
        return null;
    }

    @Override
    public Patient findNamePatient(String patientName) {
        return null;
    }
}
