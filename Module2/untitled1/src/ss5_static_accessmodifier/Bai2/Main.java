package ss5_static_accessmodifier.Bai2;

import ss5_static_accessmodifier.Bai2.Bai2;

public class Main {
    public static void main(String[] args) {
        Bai2 student = new Bai2();

        student.setName("Alice");
        student.setClasses("C01");

        System.out.println("Name: " + student.getName());
        System.out.println("Class: " + student.getClasses());
    }
}
