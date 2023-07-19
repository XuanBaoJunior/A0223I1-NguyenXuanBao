package thi_cuoi_module.model;

public class TKTietKiem extends TKNganHang {
    private String soTienGuiTietKiem;
    private String ngayGuiTietKiem;
    private String laiSuat;
    private String kyHan;

    public TKTietKiem() {
    }

    public TKTietKiem(String soTienGuiTietKiem, String ngayGuiTietKiem, String laiSuat, String kyHan) {
        this.soTienGuiTietKiem = soTienGuiTietKiem;
        this.ngayGuiTietKiem = ngayGuiTietKiem;
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public TKTietKiem(int id, String maTaiKhoan, String tenChuTaiKhoan, String ngayTaoTk, String soTienGuiTietKiem, String ngayGuiTietKiem, String laiSuat, String kyHan) {
        super(id, maTaiKhoan, tenChuTaiKhoan, ngayTaoTk);
        this.soTienGuiTietKiem = soTienGuiTietKiem;
        this.ngayGuiTietKiem = ngayGuiTietKiem;
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public String getSoTienGuiTietKiem() {
        return soTienGuiTietKiem;
    }

    public void setSoTienGuiTietKiem(String soTienGuiTietKiem) {
        this.soTienGuiTietKiem = soTienGuiTietKiem;
    }

    public String getNgayGuiTietKiem() {
        return ngayGuiTietKiem;
    }

    public void setNgayGuiTietKiem(String ngayGuiTietKiem) {
        this.ngayGuiTietKiem = ngayGuiTietKiem;
    }

    public String getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(String laiSuat) {
        this.laiSuat = laiSuat;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public String toString() {
        return super.toString()+ " - "+ soTienGuiTietKiem+ " - "+ ngayGuiTietKiem+ " - "+ laiSuat+ " - "+ kyHan ;
    }
}
