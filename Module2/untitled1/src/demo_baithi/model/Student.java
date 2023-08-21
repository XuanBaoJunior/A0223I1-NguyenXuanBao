package demo_baithi.model;

public class Student extends Person{
    private double point;
    private String classs;
    private String academic;

    public Student(double point, String classs, String academic) {
        this.point = point;
        this.classs = classs;
        this.academic = academic;
    }

    public Student(int id, String name, int age, double point, String classs, String academic) {
        super(id, name, age);
        this.point = point;
        this.classs = classs;
        this.academic = academic;
    }

    public Student() {
    }

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getAcademic() {
        return academic;
    }

    public void setAcademic(String academic) {
        this.academic = academic;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", point=" + point +
                ", classs='" + classs + '\'' +
                ", academic='" + academic + '\'' +
                '}';
    }
}
