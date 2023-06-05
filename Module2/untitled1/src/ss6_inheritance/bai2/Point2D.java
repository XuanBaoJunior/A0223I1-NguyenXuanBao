package ss6_inheritance.bai2;

public class Point2D {
        protected double x;
        protected double y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public void setX(double x) {
            this.x = x;
        }

        public void setY(double y) {
            this.y = y;
        }

        public void getCoordinates() {
            System.out.println("(" + x + ", " + y + ")");
        }
    }
