package demo_baithibenhvien.model;

import java.util.Date;

public class Patient extends Person {
    private int cccd;
    private String baoHiemYTe;
    private String benhAn;
    private Date ngayNhapVien;
    private Date ngayRaVien;

    public Patient() {
    }

    public Patient(int cccd, String baoHiemYTe, String benhAn, Date ngayNhapVien, Date ngayRaVien) {
        this.cccd = cccd;
        this.baoHiemYTe = baoHiemYTe;
        this.benhAn = benhAn;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
    }

    public Patient(int id, String name, String gioiTinh, int cccd, String baoHiemYTe, String benhAn, Date ngayNhapVien, Date ngayRaVien) {
        super(id, name, gioiTinh);
        this.cccd = cccd;
        this.baoHiemYTe = baoHiemYTe;
        this.benhAn = benhAn;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
    }

    public int getCccd() {
        return cccd;
    }

    public void setCccd(int cccd) {
        this.cccd = cccd;
    }

    public String getBaoHiemYTe() {
        return baoHiemYTe;
    }

    public void setBaoHiemYTe(String baoHiemYTe) {
        this.baoHiemYTe = baoHiemYTe;
    }

    public String getBenhAn() {
        return benhAn;
    }

    public void setBenhAn(String benhAn) {
        this.benhAn = benhAn;
    }

    public Date getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(Date ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public Date getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(Date ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", gioiTinh='" + getGioiTinh() + '\'' +
                ", cccd=" + cccd +
                ", baoHiemYTe='" + baoHiemYTe + '\'' +
                ", benhAn='" + benhAn + '\'' +
                ", ngayNhapVien=" + ngayNhapVien +
                ", ngayRaVien=" + ngayRaVien +
                '}';
    }
}
