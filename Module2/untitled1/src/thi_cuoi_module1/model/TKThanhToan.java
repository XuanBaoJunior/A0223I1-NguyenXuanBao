package thi_cuoi_module1.model;

public class TKThanhToan extends TKNganHang{
    private String soThe;
    private String soTienTrongTaiKhoan;

    public TKThanhToan() {
    }

    public TKThanhToan(String soThe, String soTienTrongTaiKhoan) {
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public TKThanhToan(int id, String maTaiKhoan, String tenChuTaiKhoan, String ngayTaoTk, String soThe, String soTienTrongTaiKhoan) {
        super(id, maTaiKhoan, tenChuTaiKhoan, ngayTaoTk);
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public String getSoTienTrongTaiKhoan() {
        return soTienTrongTaiKhoan;
    }

    public void setSoTienTrongTaiKhoan(String soTienTrongTaiKhoan) {
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    @Override
    public String toString() {
        return super.toString() +
                "soThe='" + soThe + '\'' +
                ", soTienTrongTaiKhoan='" + soTienTrongTaiKhoan
                ;
    }
}
