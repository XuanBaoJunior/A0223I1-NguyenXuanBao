package ss20_case_study.model;

public class Contract {
    private int id;
    private Booking booking;
    private Employee employee;
    private double depositAmount;
    private String signDate;

    public Contract() {
    }

    public Contract(int id, Booking booking, Employee employee, double depositAmount, String signDate) {
        this.id = id;
        this.booking = booking;
        this.employee = employee;
        this.depositAmount = depositAmount;
        this.signDate = signDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", booking=" + booking +
                ", employee=" + employee +
                ", depositAmount=" + depositAmount +
                ", signDate='" + signDate + '\'' +
                '}';
    }
}
