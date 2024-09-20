package com.example.ss5demo.models;

import javax.persistence.*;

@Entity(name = "loai_xe")
public class LoaiXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loai_xe",columnDefinition = "INT")
    private int id_loai_xe;
    @Column(name = "ten_loai_xe",columnDefinition = "VARCHAR(50)")
    private String ten_loai_xe;
    @Column(name = "gia_xe", columnDefinition = "DOUBLE")
    private double gia_xe;
    @Column(name = "nam_san_xuat", columnDefinition = "INT")
    private int nam_san_xuat;
    @ManyToOne
    @JoinColumn(name = "id_nuoc_san_xuat")
    private SanXuat sanXuat;

    public LoaiXe(int id_loai_xe, String ten_loai_xe, double gia_xe, int nam_san_xuat, SanXuat sanXuat) {
        this.id_loai_xe = id_loai_xe;
        this.ten_loai_xe = ten_loai_xe;
        this.gia_xe = gia_xe;
        this.nam_san_xuat = nam_san_xuat;
        this.sanXuat = sanXuat;
    }

    public LoaiXe(int id_loai_xe, String ten_loai_xe, double gia_xe, int nam_san_xuat) {
        this.id_loai_xe = id_loai_xe;
        this.ten_loai_xe = ten_loai_xe;
        this.gia_xe = gia_xe;
        this.nam_san_xuat = nam_san_xuat;
    }

    public LoaiXe() {
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

    public SanXuat getSanXuat() {
        return sanXuat;
    }

    public void setSanXuat(SanXuat sanXuat) {
        this.sanXuat = sanXuat;
    }
}
