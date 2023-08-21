package demo_baithi.model;

public class Teacher extends Person{
    private double salary;
    private String experience;

    public Teacher() {
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(double salary, String experience) {
        this.salary = salary;
        this.experience = experience;
    }

    public Teacher(int id, String name, int age, double salary, String experience) {
        super(id, name, age);
        this.salary = salary;
        this.experience = experience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", salary=" + salary +
                ", experience='" + experience + '\'' +
                '}';
    }
}
