package baitapmau_quanlynganhang.model;

public abstract class TkNganHang {
    private int id;
    private String name;
    private String sdt;
    private String birthday;
    private Double soDu;
    private String chiNhanh;

    public TkNganHang(int id, String name, String sdt, String birthday, Double soDu, String chiNhanh) {
        this.id = id;
        this.name = name;
        this.sdt = sdt;
        this.birthday = birthday;
        this.soDu = soDu;
        this.chiNhanh = chiNhanh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getSoDu() {
        return soDu;
    }

    public void setSoDu(Double soDu) {
        this.soDu = soDu;
    }

    public String getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    @Override
    public String toString() {
        return "TkNganHang{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sdt='" + sdt + '\'' +
                ", birthday='" + birthday + '\'' +
                ", soDu=" + soDu +
                ", chiNhanh='" + chiNhanh + '\'' +
                '}';
    }
    abstract TkNganHang banking();

}
