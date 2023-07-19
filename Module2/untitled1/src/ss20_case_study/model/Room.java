package ss20_case_study.model;

public class Room extends Facility{
    private boolean isFree;

    public Room(boolean isFree) {
        this.isFree = isFree;
    }

    public Room(int id, String name, double area, double rentalCost, int maxOccupancy, boolean isFree) {
        super(id, name, area, rentalCost, maxOccupancy);
        this.isFree = isFree;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "Room{" +
                "isFree=" + isFree +
                '}';
    }
}
