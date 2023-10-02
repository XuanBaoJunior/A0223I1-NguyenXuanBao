package demo_baithibenhvien1.model;

public class Doctor extends Person{
    private String sdt;
    private String chucVu;
    private String khoaBenh;
    private double salary;

    public Doctor() {
    }

    public Doctor(String sdt, String chucVu, String khoaBenh, double salary) {
        this.sdt = sdt;
        this.chucVu = chucVu;
        this.khoaBenh = khoaBenh;
        this.salary = salary;
    }

    public Doctor(int id, String name, String gioiTinh, String sdt, String chucVu, String khoaBenh, double salary) {
        super(id, name, gioiTinh);
        this.sdt = sdt;
        this.chucVu = chucVu;
        this.khoaBenh = khoaBenh;
        this.salary = salary;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getKhoaBenh() {
        return khoaBenh;
    }

    public void setKhoaBenh(String khoaBenh) {
        this.khoaBenh = khoaBenh;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + getId()+ '\'' +
                ", name='" + getName() + '\'' +
                ", gioiTinh='" + getGioiTinh() + '\'' +
                ", sdt='" + sdt + '\'' +
                ", chucVu='" + chucVu + '\'' +
                ", khoaBenh='" + khoaBenh + '\'' +
                ", salary=" + salary +
                '}';
    }
}
