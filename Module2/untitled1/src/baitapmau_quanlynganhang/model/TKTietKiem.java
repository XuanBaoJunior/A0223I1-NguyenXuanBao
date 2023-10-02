package baitapmau_quanlynganhang.model;

public class TKTietKiem extends TkNganHang{
    private String soTk;
    private String status;

    public TKTietKiem(int id, String name, String sdt, String birthday, Double soDu, String chiNhanh, String soTk, String status) {
        super(id, name, sdt, birthday, soDu, chiNhanh);
        this.soTk = soTk;
        this.status = status;
    }

    public String getSoTk() {
        return soTk;
    }

    public void setSoTk(String soTk) {
        this.soTk = soTk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TKTietKiem{" +
                "soTk='" + soTk + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    TkNganHang banking() {
        return null;
    }
}
