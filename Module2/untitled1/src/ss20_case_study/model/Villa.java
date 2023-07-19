package ss20_case_study.model;

public class Villa extends Facility {
    private int numberOfFloors;

    public Villa(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(int id, String name, double area, double rentalCost, int maxOccupancy, int numberOfFloors) {
        super(id, name, area, rentalCost, maxOccupancy);
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "numberOfFloors=" + numberOfFloors +
                '}';
    }
}
