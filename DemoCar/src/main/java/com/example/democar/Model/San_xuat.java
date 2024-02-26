package com.example.democar.Model;

public class San_xuat {
    private Integer id_san_xuat;
    private String nuoc_san_xuat;

    public San_xuat() {
    }

    public San_xuat(Integer id_san_xuat, String nuoc_san_xuat) {
        this.id_san_xuat = id_san_xuat;
        this.nuoc_san_xuat = nuoc_san_xuat;
    }

    public San_xuat(Integer id_san_xuat) {
        this.id_san_xuat = id_san_xuat;
    }

    public San_xuat(String nuoc_san_xuat) {
        this.nuoc_san_xuat = nuoc_san_xuat;
    }

    public int getId_san_xuat() {
        return id_san_xuat;
    }

    public void setId_san_xuat(Integer id_san_xuat) {
        this.id_san_xuat = id_san_xuat;
    }

    public String getNuoc_san_xuat() {
        return nuoc_san_xuat;
    }

    public void setNuoc_san_xuat(String nuoc_san_xuat) {
        this.nuoc_san_xuat = nuoc_san_xuat;
    }
}
