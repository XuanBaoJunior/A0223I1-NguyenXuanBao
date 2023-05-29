package ss4_oop;

    public class Main {
        public static void main(String[] args) {
            Bai1 equation = new Bai1(1, -3, 2);
            if (equation.hasRealRoots()) {
                double root1 = equation.getRoot1();
                double root2 = equation.getRoot2();
                System.out.println("Nghiệm 1: " + root1);
                System.out.println("Nghiệm 2: " + root2);
            } else {
                System.out.println("Không tồn tại");
            }
        }
    }
