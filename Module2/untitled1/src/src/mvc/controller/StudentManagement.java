package src.mvc.controller;


import src.mvc.model.Student;
import src.mvc.service.IStudentService;
import src.mvc.service.StudentService;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        IStudentService iStudentService = new StudentService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap ten");
        String name = scanner.nextLine();
        System.out.println("Nhap ten lop");
        String className = scanner.nextLine();
        Student student = new Student(id,name,className);
        iStudentService.add(student);
        System.out.println(iStudentService.showList());


    }
}
