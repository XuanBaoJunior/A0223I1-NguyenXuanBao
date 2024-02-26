package com.example.democar.Model;

public class Loai_xe {
    private Integer id_loai_xe;
    private String name;
    private Double gia_xe;
    private Integer nam_san_xuat;

    public Integer getId_loai_xe() {
        return id_loai_xe;
    }

    public void setId_loai_xe(Integer id_loai_xe) {
        this.id_loai_xe = id_loai_xe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGia_xe() {
        return gia_xe;
    }

    public void setGia_xe(Double gia_xe) {
        this.gia_xe = gia_xe;
    }

    public Integer getNam_san_xuat() {
        return nam_san_xuat;
    }

    public void setNam_san_xuat(Integer nam_san_xuat) {
        this.nam_san_xuat = nam_san_xuat;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public San_xuat getSan_xuat() {
        return san_xuat;
    }

    public void setSan_xuat(San_xuat san_xuat) {
        this.san_xuat = san_xuat;
    }

    private String color;
    private String mota;
    private San_xuat san_xuat;

    public Loai_xe() {
    }

    public Loai_xe(Integer id_loai_xe, String name, Double gia_xe, Integer nam_san_xuat, String color, String mota) {
        this.id_loai_xe = id_loai_xe;
        this.name = name;
        this.gia_xe = gia_xe;
        this.nam_san_xuat = nam_san_xuat;
        this.color = color;
        this.mota = mota;
    }

    public Loai_xe(String name, Double gia_xe, Integer nam_san_xuat, String color, String mota, San_xuat san_xuat) {
        this.name = name;
        this.gia_xe = gia_xe;
        this.nam_san_xuat = nam_san_xuat;
        this.color = color;
        this.mota = mota;
        this.san_xuat = san_xuat;
    }

    public Loai_xe(Integer id_loai_xe, String name, Double gia_xe, Integer nam_san_xuat, String color, String mota, San_xuat san_xuat) {
        this.id_loai_xe = id_loai_xe;
        this.name = name;
        this.gia_xe = gia_xe;
        this.nam_san_xuat = nam_san_xuat;
        this.color = color;
        this.mota = mota;
        this.san_xuat = san_xuat;
    }


}
