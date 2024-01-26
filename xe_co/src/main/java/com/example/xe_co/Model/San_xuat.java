package com.example.xe_co.Model;

public class San_xuat {
    private int id_nuoc_san_xuat;
    private String nuoc_san_xuat;

    public San_xuat() {
    }

    public San_xuat(int id_nuoc_san_xuat, String nuoc_san_xuat) {
        this.id_nuoc_san_xuat = id_nuoc_san_xuat;
        this.nuoc_san_xuat = nuoc_san_xuat;
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
