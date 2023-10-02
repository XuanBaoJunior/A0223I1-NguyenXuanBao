package caseStudy_module2.model;

public class Contract {
    private int soHopDong;
    private int idBooking;
    private double soTienCocTruoc;
    private double tongSoTienThanhToan;
    private int idKhachHang;

    public Contract() {
    }

    public Contract(int soHopDong, int idBooking, double soTienCocTruoc, double tongSoTienThanhToan, int idKhachHang) {
        this.soHopDong = soHopDong;
        this.idBooking = idBooking;
        this.soTienCocTruoc = soTienCocTruoc;
        this.tongSoTienThanhToan = tongSoTienThanhToan;
        this.idKhachHang = idKhachHang;
    }

    public int getSoHopDong() {
        return soHopDong;
    }

    public void setSoHopDong(int soHopDong) {
        this.soHopDong = soHopDong;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public double getSoTienCocTruoc() {
        return soTienCocTruoc;
    }

    public void setSoTienCocTruoc(double soTienCocTruoc) {
        this.soTienCocTruoc = soTienCocTruoc;
    }

    public double getTongSoTienThanhToan() {
        return tongSoTienThanhToan;
    }

    public void setTongSoTienThanhToan(double tongSoTienThanhToan) {
        this.tongSoTienThanhToan = tongSoTienThanhToan;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "soHopDong=" + soHopDong +
                ", idBooking=" + idBooking +
                ", soTienCocTruoc=" + soTienCocTruoc +
                ", tongSoTienThanhToan=" + tongSoTienThanhToan +
                ", idKhachHang=" + idKhachHang +
                '}';
    }
}
