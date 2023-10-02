package caseStudy_module2.model;

public class Customer extends Person{
    private int idKhachHang;
    private String loaiKhach;
    private String diaChi;

    public Customer() {
    }

    public Customer(int idKhachHang, String loaiKhach, String diaChi) {
        this.idKhachHang = idKhachHang;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public Customer(String hoTen, String ngaySinh, String gioiTinh, String soCMND, String SDT, String email, int idKhachHang, String loaiKhach, String diaChi) {
        super(hoTen, ngaySinh, gioiTinh, soCMND, SDT, email);
        this.idKhachHang = idKhachHang;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idKhachHang=" + idKhachHang +
                ", hoTen='" + getHoTen() + '\'' +
                ", ngaySinh='" + getNgaySinh() + '\'' +
                ", gioiTinh='" + getGioiTinh() + '\'' +
                ", soCMND='" + getSoCMND() + '\'' +
                ", SDT='" + getSDT() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", loaiKhach='" + loaiKhach + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
