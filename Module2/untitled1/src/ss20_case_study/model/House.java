package ss20_case_study.model;

public class House extends Facility {
    private String gardenType;

    public House(String gardenType) {
        this.gardenType = gardenType;
    }

    public House(int id, String name, double area, double rentalCost, int maxOccupancy, String gardenType) {
        super(id, name, area, rentalCost, maxOccupancy);
        this.gardenType = gardenType;
    }

    public String getGardenType() {
        return gardenType;
    }

    public void setGardenType(String gardenType) {
        this.gardenType = gardenType;
    }

    @Override
    public String toString() {
        return "House{" +
                "gardenType='" + gardenType + '\'' +
                '}';
    }
}
