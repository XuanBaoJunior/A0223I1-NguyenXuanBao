package thi_ket_thuc_module.model;

import java.util.Objects;

public class QLDanhBa {
    private int id;
    private String hoTen;
    private String soDienThoai;
    private String diaChi;
    private String email;
    private String facebook;

    public QLDanhBa() {
    }

    public QLDanhBa(int id, String hoTen, String soDienThoai, String diaChi, String email, String facebook) {
        this.id = id;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.email = email;
        this.facebook = facebook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", hoTen='" + hoTen + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", email='" + email + '\'' +
                ", facebook='" + facebook
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QLDanhBa qlDanhBa = (QLDanhBa) o;
        return id == qlDanhBa.id && Objects.equals(hoTen, qlDanhBa.hoTen) && Objects.equals(soDienThoai, qlDanhBa.soDienThoai) && Objects.equals(diaChi, qlDanhBa.diaChi) && Objects.equals(email, qlDanhBa.email) && Objects.equals(facebook, qlDanhBa.facebook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hoTen, soDienThoai, diaChi, email, facebook);
    }
}
