package demo_quanlyphuongtiengiaothong.model;

public abstract class PhuongTien {
    private int id;
    private String bienSo;
    private String nhaSanXuat;
    private String namSanXuat;
    private String chuSoHuu;

    public PhuongTien(int id, String bienSo, String nhaSanXuat, String namSanXuat, String chuSoHuu) {
        this.id = id;
        this.bienSo = bienSo;
        this.nhaSanXuat = nhaSanXuat;
        this.namSanXuat = namSanXuat;
        this.chuSoHuu = chuSoHuu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(String namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return "PhuongTien{" +
                "id=" + id +
                ", bienSo='" + bienSo + '\'' +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                ", namSanXuat='" + namSanXuat + '\'' +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                '}';
    }
    public abstract void toPhuongTien();
}
