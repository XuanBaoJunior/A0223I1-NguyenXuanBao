package baitapmau_quanlynganhang.model;

public class TKTinDung extends TkNganHang{
    private String soThe;
    private int maPin;

    public TKTinDung(int id, String name, String sdt, String birthday, Double soDu, String chiNhanh, String soThe, int maPin) {
        super(id, name, sdt, birthday, soDu, chiNhanh);
        this.soThe = soThe;
        this.maPin = maPin;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public int getMaPin() {
        return maPin;
    }

    public void setMaPin(int maPin) {
        this.maPin = maPin;
    }

    @Override
    public String toString() {
        return "TKTinDung{" +
                "soThe='" + soThe + '\'' +
                ", maPin=" + maPin +
                '}';
    }

    @Override
    TkNganHang banking() {
        return null;
    }
}
