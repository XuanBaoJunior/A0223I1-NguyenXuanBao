package com.example.quan_ly_bookk.DTO;

import java.util.Date;

public class TheMuonSachDTO {
    private String ma_muon;
    private String trang_thai;
    private Date ngay_muon;
    private Date ngay_tra;
    private String name_book;
    private String name_student;

    public TheMuonSachDTO() {
    }

    public TheMuonSachDTO(String ma_muon, String trang_thai, Date ngay_muon, Date ngay_tra, String name_book, String name_student) {
        this.ma_muon = ma_muon;
        this.trang_thai = trang_thai;
        this.ngay_muon = ngay_muon;
        this.ngay_tra = ngay_tra;
        this.name_book = name_book;
        this.name_student = name_student;
    }

    public String getMa_muon() {
        return ma_muon;
    }

    public void setMa_muon(String ma_muon) {
        this.ma_muon = ma_muon;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    public Date getNgay_muon() {
        return ngay_muon;
    }

    public void setNgay_muon(Date ngay_muon) {
        this.ngay_muon = ngay_muon;
    }

    public Date getNgay_tra() {
        return ngay_tra;
    }

    public void setNgay_tra(Date ngay_tra) {
        this.ngay_tra = ngay_tra;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getName_student() {
        return name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }
}
