package ss5_static_accessmodifier;

public class Bai1 {
    private double radius;
    private String color;

    public Bai1() {
        radius = 1.0;
        color = "red";
    }

    public Bai1(double radius) {
        this.radius = radius;
        color = "red";
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

