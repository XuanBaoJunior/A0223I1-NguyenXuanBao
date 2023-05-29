package ss5_static_accessmodifier;

public class Main2 {
    public static void main(String[] args) {
        Bai2 student = new Bai2();

        student.setName("Alice");
        student.setClasses("C01");

        System.out.println("Name: " + student.getName());
        System.out.println("Class: " + student.getClasses());
    }
}
