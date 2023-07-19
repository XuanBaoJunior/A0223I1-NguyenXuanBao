package ss20_case_study.model;

public abstract class Facility {
    private int id;
    private String name;
    private double area;
    private double rentalCost;
    private int maxOccupancy;

    public Facility() {
    }

    public Facility(int id, String name, double area, double rentalCost, int maxOccupancy) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.rentalCost = rentalCost;
        this.maxOccupancy = maxOccupancy;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", rentalCost=" + rentalCost +
                ", maxOccupancy=" + maxOccupancy +
                '}';
    }
}
