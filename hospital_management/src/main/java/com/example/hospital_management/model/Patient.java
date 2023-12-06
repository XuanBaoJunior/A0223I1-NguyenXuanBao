package com.example.hospital_management.model;

public class Patient {
    private int id_patient;
    private String name_patient;
    private int age_patient;

    public Patient() {
    }

    public Patient(String name_patient, int age_patient) {
        this.name_patient = name_patient;
        this.age_patient = age_patient;
    }

    public Patient(int id_patient, String name_patient, int age_patient) {
        this.id_patient = id_patient;
        this.name_patient = name_patient;
        this.age_patient = age_patient;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public String getName_patient() {
        return name_patient;
    }

    public void setName_patient(String name_patient) {
        this.name_patient = name_patient;
    }

    public int getAge_patient() {
        return age_patient;
    }

    public void setAge_patient(int age_patient) {
        this.age_patient = age_patient;
    }
}
