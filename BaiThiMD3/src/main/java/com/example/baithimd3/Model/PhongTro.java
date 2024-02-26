package com.example.baithimd3.Model;

public class PhongTro {
    private Integer id;
    private String hinh_thuc_thanh_toan;
    private String ghi_chu;

    public PhongTro() {
    }

    public PhongTro(Integer id, String hinh_thuc_thanh_toan, String ghi_chu) {
        this.id = id;
        this.hinh_thuc_thanh_toan = hinh_thuc_thanh_toan;
        this.ghi_chu = ghi_chu;
    }

    public PhongTro(Integer id) {
        this.id = id;
    }

    public PhongTro(Integer id, String ghi_chu) {
        this.id = id;
        this.ghi_chu = ghi_chu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHinh_thuc_thanh_toan() {
        return hinh_thuc_thanh_toan;
    }

    public void setHinh_thuc_thanh_toan(String hinh_thuc_thanh_toan) {
        this.hinh_thuc_thanh_toan = hinh_thuc_thanh_toan;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }
}
