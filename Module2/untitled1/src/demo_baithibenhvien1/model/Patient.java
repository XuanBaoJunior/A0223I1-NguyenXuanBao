package demo_baithibenhvien1.model;

public class Patient extends Person{
    private String cccd;
    private String baoHiemYTe;
    private String benhAn;
    private String ngayNhapVien;
    private String ngayRaVien;

    public Patient() {
    }

    public Patient(String cccd, String baoHiemYTe, String benhAn, String ngayNhapVien, String ngayRaVien) {
        this.cccd = cccd;
        this.baoHiemYTe = baoHiemYTe;
        this.benhAn = benhAn;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
    }

    public Patient(int id, String name, String gioiTinh, String cccd, String baoHiemYTe, String benhAn, String ngayNhapVien, String ngayRaVien) {
        super(id, name, gioiTinh);
        this.cccd = cccd;
        this.baoHiemYTe = baoHiemYTe;
        this.benhAn = benhAn;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
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

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + getId()+ '\'' +
                ", name='" + getName() + '\'' +
                ", gioiTinh='" + getGioiTinh() + '\'' +
                ", cccd=" + cccd +
                ", baoHiemYTe='" + baoHiemYTe + '\'' +
                ", benhAn='" + benhAn + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", ngayRaVien='" + ngayRaVien + '\'' +
                '}';
    }
}
