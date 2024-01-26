package com.example.benh_an.Model;

public class Benh_nhan {
    private String id_benh_nhan;
    private String ten_benh_nhan;

    public Benh_nhan() {
    }

    public Benh_nhan(String id_benh_nhan) {
        this.id_benh_nhan = id_benh_nhan;
    }

    public Benh_nhan(String id_benh_nhan, String ten_benh_nhan) {
        this.id_benh_nhan = id_benh_nhan;
        this.ten_benh_nhan = ten_benh_nhan;
    }

    public String getId_benh_nhan() {
        return id_benh_nhan;
    }

    public void setId_benh_nhan(String id_benh_nhan) {
        this.id_benh_nhan = id_benh_nhan;
    }

    public String getTen_benh_nhan() {
        return ten_benh_nhan;
    }

    public void setTen_benh_nhan(String ten_benh_nhan) {
        this.ten_benh_nhan = ten_benh_nhan;
    }
}
