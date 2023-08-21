package ss6_inheritance.demo;

public class demo1 extends demo{
    private float z;

    public demo1(float z) {
        this.z = z;
    }

    public demo1(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public demo1() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}
