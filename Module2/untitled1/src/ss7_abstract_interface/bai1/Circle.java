package ss7_abstract_interface.bai1;

public class Circle implements Resizeable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void resize(double percent) {
        radius *= (1 + percent / 100);
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
