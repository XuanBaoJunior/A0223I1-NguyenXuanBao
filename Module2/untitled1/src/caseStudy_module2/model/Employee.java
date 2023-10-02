package caseStudy_module2.model;

public class Employee extends Person{
    private int idNhanVien;
    private String trinhDo;
    private String viTri;
    private double luong;

    public Employee() {
    }

    public Employee(String hoTen, String ngaySinh, String gioiTinh, String soCMND, String SDT, String email) {
        super(hoTen, ngaySinh, gioiTinh, soCMND, SDT, email);
    }

    public Employee(int idNhanVien, String trinhDo, String viTri, double luong) {
        this.idNhanVien = idNhanVien;
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
    }

    public Employee(String hoTen, String ngaySinh, String gioiTinh, String soCMND, String SDT, String email, int idNhanVien, String trinhDo, String viTri, double luong) {
        super(hoTen, ngaySinh, gioiTinh, soCMND, SDT, email);
        this.idNhanVien = idNhanVien;
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idNhanVien=" + idNhanVien +
                ", hoTen='" + getHoTen() + '\'' +
                ", ngaySinh='" + getNgaySinh() + '\'' +
                ", gioiTinh='" + getGioiTinh() + '\'' +
                ", soCMND='" + getSoCMND() + '\'' +
                ", SDT='" + getSDT() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", trinhDo='" + trinhDo + '\'' +
                ", viTri='" + viTri + '\'' +
                ", luong=" + luong +
                '}';
    }
}
