package com.example.xe_co.Model;

public class Loai_xe {
    private int id_loai_xe;
    private String ten_loai_xe;
    private double gia_xe;
    private int nam_san_xuat;
    private San_xuat san_xuat;

    public Loai_xe() {
    }

    public Loai_xe(String ten_loai_xe, double gia_xe, int nam_san_xuat, San_xuat san_xuat) {
        this.ten_loai_xe = ten_loai_xe;
        this.gia_xe = gia_xe;
        this.nam_san_xuat = nam_san_xuat;
        this.san_xuat = san_xuat;
    }

    public Loai_xe(int id_loai_xe, String ten_loai_xe, double gia_xe, int nam_san_xuat) {
        this.id_loai_xe = id_loai_xe;
        this.ten_loai_xe = ten_loai_xe;
        this.gia_xe = gia_xe;
        this.nam_san_xuat = nam_san_xuat;
    }

    public Loai_xe(int id_loai_xe, String ten_loai_xe, double gia_xe, int nam_san_xuat, San_xuat san_xuat) {
        this.id_loai_xe = id_loai_xe;
        this.ten_loai_xe = ten_loai_xe;
        this.gia_xe = gia_xe;
        this.nam_san_xuat = nam_san_xuat;
        this.san_xuat = san_xuat;
    }

    public int getId_loai_xe() {
        return id_loai_xe;
    }

    public void setId_loai_xe(int id_loai_xe) {
        this.id_loai_xe = id_loai_xe;
    }

    public String getTen_loai_xe() {
        return ten_loai_xe;
    }

    public void setTen_loai_xe(String ten_loai_xe) {
        this.ten_loai_xe = ten_loai_xe;
    }

    public double getGia_xe() {
        return gia_xe;
    }

    public void setGia_xe(double gia_xe) {
        this.gia_xe = gia_xe;
    }

    public int getNam_san_xuat() {
        return nam_san_xuat;
    }

    public void setNam_san_xuat(int nam_san_xuat) {
        this.nam_san_xuat = nam_san_xuat;
    }

    public San_xuat getSan_xuat() {
        return san_xuat;
    }

    public void setSan_xuat(San_xuat san_xuat) {
        this.san_xuat = san_xuat;
    }
}
