package ss16_readfile_writefile.views;

import ss16_readfile_writefile.commons.FuncFileCSV;
import ss16_readfile_writefile.models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> listStudent = new ArrayList<Student>();
    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu(){
        System.out.println("Please choose you want: \n" +
                "1. Add new student. \n" +
                    "2. Show Information Student. \n" +
                "3. Exit. ");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.nextLine();
        switch (choose){
            case  "1":
                addNewStudent();
                break;
            case "2":
                showInformationStudent();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Fail! Enter continue!!!");
                scanner.nextLine();
                displayMainMenu();
                break;
        }
    }

    private static void showInformationStudent() {
        listStudent = FuncFileCSV.getFileCSVToListStudent();
        for (Student student:listStudent){
            System.out.println("---------------------------------");
            System.out.println("Name: " + student.getName());
            System.out.println("Grade: " + student.getGrade());
            System.out.println("Address: " + student.getAddress());
            System.out.println("---------------------------------");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter continue!!!");
        scanner.nextLine();
        displayMainMenu();
    }

    private static void addNewStudent() {
        listStudent = FuncFileCSV.getFileCSVToListStudent();
        Scanner scanner = new Scanner(System.in);

        Student student = new Student();
        System.out.println("Enter name: ");
        student.setName(scanner.nextLine());
        System.out.println("Enter grade: ");
        student.setGrade(scanner.nextLine());
        System.out.println("Enter address: ");
        student.setAddress(scanner.nextLine());
        listStudent.add(student);
        FuncFileCSV.writeStudentToFileCSV(listStudent);
        System.out.println("Add new student complete! Enter continue!!!");
        scanner.nextLine();
        displayMainMenu();
    }
}
