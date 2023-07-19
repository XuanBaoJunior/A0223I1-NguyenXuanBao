package ss20_case_study.model;

public class Customer extends Person{
    private int loyaltyPoints;

    public Customer(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Customer(int id, String name, String gender, String address, String phoneNumber, int loyaltyPoints) {
        super(id, name, gender, address, phoneNumber);
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
