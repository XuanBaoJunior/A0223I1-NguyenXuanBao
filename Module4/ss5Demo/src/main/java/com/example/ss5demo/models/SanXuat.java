package com.example.ss5demo.models;

import javax.persistence.*;

@Entity(name = "san_xuat")
public class SanXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nuoc_san_xuat",columnDefinition = "INT")
    private int id_nuoc_san_xuat;
    @Column(name = "nuoc_san_xuat",columnDefinition = "VARCHAR(100)")
    private String nuoc_san_xuat;

    public SanXuat(int id_nuoc_san_xuat, String nuoc_san_xuat) {
        this.id_nuoc_san_xuat = id_nuoc_san_xuat;
        this.nuoc_san_xuat = nuoc_san_xuat;
    }

    public SanXuat() {
    }

    public int getId_nuoc_san_xuat() {
        return id_nuoc_san_xuat;
    }

    public void setId_nuoc_san_xuat(int id_nuoc_san_xuat) {
        this.id_nuoc_san_xuat = id_nuoc_san_xuat;
    }

    public String getNuoc_san_xuat() {
        return nuoc_san_xuat;
    }

    public void setNuoc_san_xuat(String nuoc_san_xuat) {
        this.nuoc_san_xuat = nuoc_san_xuat;
    }
}
