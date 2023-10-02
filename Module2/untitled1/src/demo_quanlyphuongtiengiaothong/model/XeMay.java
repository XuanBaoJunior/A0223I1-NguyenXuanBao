package demo_quanlyphuongtiengiaothong.model;

public class XeMay extends PhuongTien{
    private String congSuat;

    public XeMay(int id, String bienSo, String nhaSanXuat, String namSanXuat, String chuSoHuu, String congSuat) {
        super(id, bienSo, nhaSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public String getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "XeMay{" +
                "id=" + getId() +
                ", bienSo='" + getBienSo() + '\'' +
                ", nhaSanXuat='" + getNhaSanXuat() + '\'' +
                ", namSanXuat='" + getNamSanXuat() + '\'' +
                ", chuSoHuu='" + getChuSoHuu() + '\'' +
                ", congSuat='" + congSuat + '\'' +
                '}';
    }

    @Override
    public void toPhuongTien() {

    }
}
