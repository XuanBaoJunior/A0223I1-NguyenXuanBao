package com.example.quan_ly_book.model;

import java.util.Date;

public class The_muon_sach {
    private String ma_muon;
    private String trang_thai;
    private Date ngay_muon;
    private Date ngay_tra;
    private Book book;
    private Student student;

    public The_muon_sach() {
    }

    public The_muon_sach(String ma_muon, String trang_thai, Date ngay_muon, Date ngay_tra, Book book, Student student) {
        this.ma_muon = ma_muon;
        this.trang_thai = trang_thai;
        this.ngay_muon = ngay_muon;
        this.ngay_tra = ngay_tra;
        this.book = book;
        this.student = student;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
