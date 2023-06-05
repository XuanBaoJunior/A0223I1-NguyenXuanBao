package ss6_inheritance.bai2;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(3, 4);
        System.out.println("Point2D coordinates: ");
        point2D.getCoordinates();

        Point3D point3D = new Point3D(1, 2, 3);
        System.out.println("Point3D coordinates: ");
        point3D.getCoordinates();
    }
}

