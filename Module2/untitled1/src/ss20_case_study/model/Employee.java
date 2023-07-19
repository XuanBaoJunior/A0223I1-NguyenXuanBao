package ss20_case_study.model;

public class Employee extends Person {
    private String position;

    public Employee(String position) {
        this.position = position;
    }

    public Employee(int id, String name, String gender, String address, String phoneNumber, String position) {
        super(id, name, gender, address, phoneNumber);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "position='" + position + '\'' +
                '}';
    }
}
