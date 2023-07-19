package thi_cuoi_module1.model;

import java.util.Objects;

public abstract class TKNganHang {
    private int id;
    private String maTaiKhoan;
    private String tenChuTaiKhoan;
    private String ngayTaoTk;

    public TKNganHang() {
    }

    public TKNganHang(int id, String maTaiKhoan, String tenChuTaiKhoan, String ngayTaoTk) {
        this.id = id;
        this.maTaiKhoan = maTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.ngayTaoTk = ngayTaoTk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenChuTaiKhoan() {
        return tenChuTaiKhoan;
    }

    public void setTenChuTaiKhoan(String tenChuTaiKhoan) {
        this.tenChuTaiKhoan = tenChuTaiKhoan;
    }

    public String getNgayTaoTk() {
        return ngayTaoTk;
    }

    public void setNgayTaoTk(String ngayTaoTk) {
        this.ngayTaoTk = ngayTaoTk;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", maTaiKhoan='" + maTaiKhoan + '\'' +
                ", tenChuTaiKhoan='" + tenChuTaiKhoan + '\'' +
                ", ngayTaoTk='" + ngayTaoTk
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TKNganHang that = (TKNganHang) o;
        return id == that.id && Objects.equals(maTaiKhoan, that.maTaiKhoan) && Objects.equals(tenChuTaiKhoan, that.tenChuTaiKhoan) && Objects.equals(ngayTaoTk, that.ngayTaoTk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maTaiKhoan, tenChuTaiKhoan, ngayTaoTk);
    }
}
