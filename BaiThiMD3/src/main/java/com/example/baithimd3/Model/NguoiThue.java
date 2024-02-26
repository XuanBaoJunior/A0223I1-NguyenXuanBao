package com.example.baithimd3.Model;

public class NguoiThue {
    private String id_nguoi_thue;
    private String ten_nguoi_thue;
    private String so_dien_thoai;
    private String ngay_thue;
    private PhongTro phongTro;

    public NguoiThue() {
    }

    public NguoiThue(String id_nguoi_thue, String ten_nguoi_thue, String so_dien_thoai, String ngay_thue, PhongTro phongTro) {
        this.id_nguoi_thue = id_nguoi_thue;
        this.ten_nguoi_thue = ten_nguoi_thue;
        this.so_dien_thoai = so_dien_thoai;
        this.ngay_thue = ngay_thue;
        this.phongTro = phongTro;
    }

    public NguoiThue(String ten_nguoi_thue, String so_dien_thoai, String ngay_thue, PhongTro phongTro) {
        this.ten_nguoi_thue = ten_nguoi_thue;
        this.so_dien_thoai = so_dien_thoai;
        this.ngay_thue = ngay_thue;
        this.phongTro = phongTro;
    }

    public NguoiThue(String id_nguoi_thue, String ten_nguoi_thue, String so_dien_thoai, String ngay_thue) {
        this.id_nguoi_thue = id_nguoi_thue;
        this.ten_nguoi_thue = ten_nguoi_thue;
        this.so_dien_thoai = so_dien_thoai;
        this.ngay_thue = ngay_thue;
    }

    public String getId_nguoi_thue() {
        return id_nguoi_thue;
    }

    public void setId_nguoi_thue(String id_nguoi_thue) {
        this.id_nguoi_thue = id_nguoi_thue;
    }

    public String getTen_nguoi_thue() {
        return ten_nguoi_thue;
    }

    public void setTen_nguoi_thue(String ten_nguoi_thue) {
        this.ten_nguoi_thue = ten_nguoi_thue;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public String getNgay_thue() {
        return ngay_thue;
    }

    public void setNgay_thue(String ngay_thue) {
        this.ngay_thue = ngay_thue;
    }

    public PhongTro getPhongTro() {
        return phongTro;
    }

    public void setPhongTro(PhongTro phongTro) {
        this.phongTro = phongTro;
    }
}
