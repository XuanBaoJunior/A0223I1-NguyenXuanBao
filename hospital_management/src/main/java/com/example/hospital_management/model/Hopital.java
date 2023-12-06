package com.example.hospital_management.model;

import java.util.Date;

public class Hopital {
    private int id_hopital;
    private Date date_in;
    private Date date_out;
    private String reason;
    private Patient patient;

    public Hopital() {
    }

    public Hopital(int id_hopital, Date date_in, Date date_out, String reason, Patient patient) {
        this.id_hopital = id_hopital;
        this.date_in = date_in;
        this.date_out = date_out;
        this.reason = reason;
        this.patient = patient;
    }

    public Hopital(int id_hopital, Date date_in, Date date_out, String reason) {
        this.id_hopital = id_hopital;
        this.date_in = date_in;
        this.date_out = date_out;
        this.reason = reason;
    }

    public Hopital(Date date_in, Date date_out, String reason, Patient patient) {
        this.date_in = date_in;
        this.date_out = date_out;
        this.reason = reason;
        this.patient = patient;
    }

    public int getId_hopital() {
        return id_hopital;
    }

    public void setId_hopital(int id_hopital) {
        this.id_hopital = id_hopital;
    }

    public Date getDate_in() {
        return date_in;
    }

    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    public Date getDate_out() {
        return date_out;
    }

    public void setDate_out(Date date_out) {
        this.date_out = date_out;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
