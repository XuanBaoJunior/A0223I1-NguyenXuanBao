package demo_quanlyphuongtiengiaothong.model;

public class OTo extends PhuongTien{
    private int soCho;
    private String kieuXe;

    public OTo(int id, String bienSo, String nhaSanXuat, String namSanXuat, String chuSoHuu, int soCho, String kieuXe) {
        super(id, bienSo, nhaSanXuat, namSanXuat, chuSoHuu);
        this.soCho = soCho;
        this.kieuXe = kieuXe;
    }

    public int getSoCho() {
        return soCho;
    }

    public void setSoCho(int soCho) {
        this.soCho = soCho;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return "OTo{" +
                "id=" + getId() +
                ", bienSo='" + getBienSo() + '\'' +
                ", nhaSanXuat='" + getNhaSanXuat() + '\'' +
                ", namSanXuat='" + getNamSanXuat() + '\'' +
                ", chuSoHuu='" + getChuSoHuu() + '\'' +
                ", soCho=" + soCho +
                ", kieuXe='" + kieuXe + '\'' +
                '}';
    }

    @Override
    public void toPhuongTien() {

    }

}
