package baimau_phone;

public abstract class Phone {
    private int id;
    private String name;
    private Double price;
    private String manufacture;

    public Phone(int id, String name, Double price, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacture = manufacture;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }

    abstract Phone toPhone();
}

