package com.example.benh_an.Model;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Benh_an {
    private String id_benh_an;
    private Date ngay_nhap_vien;
    private Date ngay_ra_vien;
    private String ly_do;
    private Benh_nhan benh_nhan;

    public Benh_an() {
    }

    public Benh_an(String id_benh_an, Date ngay_nhap_vien, Date ngay_ra_vien, String ly_do) {
        this.id_benh_an = id_benh_an;
        this.ngay_nhap_vien = ngay_nhap_vien;
        this.ngay_ra_vien = ngay_ra_vien;
        this.ly_do = ly_do;
    }

    public Benh_an(Date ngay_nhap_vien, Date ngay_ra_vien, String ly_do, Benh_nhan benh_nhan) {
        this.ngay_nhap_vien = ngay_nhap_vien;
        this.ngay_ra_vien = ngay_ra_vien;
        this.ly_do = ly_do;
        this.benh_nhan = benh_nhan;
    }

    public Benh_an(String id_benh_an, Date ngay_nhap_vien, Date ngay_ra_vien, String ly_do, Benh_nhan benh_nhan) {
        this.id_benh_an = id_benh_an;
        this.ngay_nhap_vien = ngay_nhap_vien;
        this.ngay_ra_vien = ngay_ra_vien;
        this.ly_do = ly_do;
        this.benh_nhan = benh_nhan;
    }


    public String getId_benh_an() {
        return id_benh_an;
    }

    public void setId_benh_an(String id_benh_an) {
        this.id_benh_an = id_benh_an;
    }

    public Date getNgay_nhap_vien() {
        return ngay_nhap_vien;
    }

    public void setNgay_nhap_vien(Date ngay_nhap_vien) {
        this.ngay_nhap_vien = ngay_nhap_vien;
    }

    public Date getNgay_ra_vien() {
        return ngay_ra_vien;
    }

    public void setNgay_ra_vien(Date ngay_ra_vien) {
        this.ngay_ra_vien = ngay_ra_vien;
    }

    public String getLy_do() {
        return ly_do;
    }

    public void setLy_do(String ly_do) {
        this.ly_do = ly_do;
    }

    public Benh_nhan getBenh_nhan() {
        return benh_nhan;
    }

    public void setBenh_nhan(Benh_nhan benh_nhan) {
        this.benh_nhan = benh_nhan;
    }

    public boolean isValidateReadyInsertDB(){
        if(this.id_benh_an.isEmpty()){
            return false;
        }else{
            Pattern pattern  = Pattern.compile("^BA");
            Matcher matcher= pattern.matcher(this.id_benh_an);
            return matcher.matches();
        }
    }
}
