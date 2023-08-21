package ss21_student_teacher_mvc.model;

public class Student extends Person{
    private String lopHoc;
    private double diem;
    private String hocLuc;

    public Student(String lopHoc, double diem, String hocLuc) {
        this.lopHoc = lopHoc;
        this.diem = diem;
        this.hocLuc = hocLuc;
    }

    public Student(int id, String name, int tuoi, String diaChi, String lopHoc, double diem, String hocLuc) {
        super(id, name, tuoi, diaChi);
        this.lopHoc = lopHoc;
        this.diem = diem;
        this.hocLuc = hocLuc;
    }

    public Student(int id, String name, int tuoi, String diaChi) {
        super(id, name, tuoi, diaChi);
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getHocLuc() {
        return hocLuc;
    }

    public void setHocLuc(String hocLuc) {
        this.hocLuc = hocLuc;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", tuoi=" + getTuoi() +
                ", diaChi='" + getDiaChi() + '\'' +
                ", lopHoc='" + lopHoc + '\'' +
                ", diem=" + diem +
                ", hocLuc='" + hocLuc + '\'' +
                '}';
    }
}
