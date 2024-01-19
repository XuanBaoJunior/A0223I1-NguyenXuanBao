package com.example.quan_ly_bookk.Model;

import java.util.Date;

public class TheMuonSach {
    private String ma_muon;
    private String trang_thai;
    private Date ngay_muon;
    private Date ngay_tra;
    private TheMuonSach book;
    private int id_book;
    private int id_student;

    public TheMuonSach() {
    }

    public TheMuonSach(String trang_thai, Date ngay_muon, Date ngay_tra, TheMuonSach book, int id_book, int id_student) {
        this.trang_thai = trang_thai;
        this.ngay_muon = ngay_muon;
        this.ngay_tra = ngay_tra;
        this.book = book;
        this.id_book = id_book;
        this.id_student = id_student;
    }

    public TheMuonSach(String ma_muon, String trang_thai, Date ngay_muon, Date ngay_tra, TheMuonSach book, int id_book, int id_student) {
        this.ma_muon = ma_muon;
        this.trang_thai = trang_thai;
        this.ngay_muon = ngay_muon;
        this.ngay_tra = ngay_tra;
        this.book = book;
        this.id_book = id_book;
        this.id_student = id_student;
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

    public TheMuonSach getBook() {
        return book;
    }

    public void setBook(TheMuonSach book) {
        this.book = book;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }
}