package ss21_student_teacher_mvc.model;

public class Teacher extends Person{
    private double salary;

    public Teacher(double salary) {
        this.salary = salary;
    }

    public Teacher(int id, String name, int tuoi, String diaChi, double salary) {
        super(id, name, tuoi, diaChi);
        this.salary = salary;
    }

    public Teacher() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", tuoi=" + getTuoi() +
                ", diaChi='" + getDiaChi() + '\'' +
                ", salary=" + salary +
                '}';
    }
}
