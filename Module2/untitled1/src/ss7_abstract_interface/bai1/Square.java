package ss7_abstract_interface.bai1;

public class Square implements Resizeable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public void resize(double percent) {
        side *= (1 + percent / 100);
    }

    public double getArea() {
        return side * side;
    }
}
