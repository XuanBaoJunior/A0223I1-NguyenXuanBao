package case_study.model;

public class Customer extends Person{
    private int id;
    private String name;
    private String dateOfBirth;
    private String sex;
    private int numberCMND;
    private int numberPhone;
    private String email;
    private String typeOfGuest;
    private String address;

    public Customer(int id, String name, String dateOfBirth, String sex, int numberCMND, int numberPhone, String email, String typeOfGuest, String address) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.numberCMND = numberCMND;
        this.numberPhone = numberPhone;
        this.email = email;
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getNumberCMND() {
        return numberCMND;
    }

    public void setNumberCMND(int numberCMND) {
        this.numberCMND = numberCMND;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfGuest() {
        return typeOfGuest;
    }

    public void setTypeOfGuest(String typeOfGuest) {
        this.typeOfGuest = typeOfGuest;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", sex='" + sex + '\'' +
                ", numberCMND=" + numberCMND +
                ", numberPhone=" + numberPhone +
                ", email='" + email + '\'' +
                ", typeOfGuest='" + typeOfGuest + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
