package case_study.controller;

import case_study.service.Impl.EmployeeServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu(){
        boolean check = true;
        while (check){
            System.out.println("Furama Resort Management System");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()){
                case 1:{
                    displayEmployeeMenu();
                    break;
                }
                case 2:{
                    displayCustomerMenu();
                    break;
                }
                case 3:{
                    displayFacilityMenu();
                    break;
                }
                case 4:{
                    displayBookingMenu();
                    break;
                }
                case 5:{
                    displayPromotionMenu();
                    break;
                }
                case 6:{
                    System.exit(0);
                    break;

                }
            }

        }
    }
    public static void displayEmployeeMenu(){
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        try {
            boolean check = true;
            while (check){
                System.out.println("Employee Management");
                System.out.println("1. Display List Employees");
                System.out.println("2. Add New Employee");
                System.out.println("3. Edit Employee");
                System.out.println("4. Return Main Menu");
                System.out.print("Enter your choice: ");
                Scanner scanner = new Scanner(System.in);

                switch (scanner.nextInt()){
                    case 1:{
                        employeeService.display();
                        break;
                    }
                    case 2:{
                        employeeService.addNew();
                        break;
                    }
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Mời bạn nhập lại: ");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Mời bạn nhập lại: ");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
//        boolean check = true;
//        while (check){
//            System.out.println("Employee Management");
//            System.out.println("1. Display List Employees");
//            System.out.println("2. Add New Employee");
//            System.out.println("3. Edit Employee");
//            System.out.println("4. Return Main Menu");
//            System.out.print("Enter your choice: ");
//            Scanner scanner = new Scanner(System.in);
//
//            switch (scanner.nextInt()){
//                case 1:
//            }
//        }
    }
    public static void displayCustomerMenu(){
        boolean check = true;
        while (check){
            System.out.println("Customer Management");
            System.out.println("1. Display List Customers");
            System.out.println("2. Add New Customer");
            System.out.println("3. Edit Customer");
            System.out.println("4. Return Main Menu");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()){
                case 1:
            }
        }
    }
    public static void displayFacilityMenu(){
        boolean check = true;
        while (check){
            System.out.println("Facility Management");
            System.out.println("1. Display List Facility");
            System.out.println("2. Add New Facility");
            System.out.println("3. Edit Facility");
            System.out.println("4. Return Main Menu");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()){
                case 1:
            }
        }
    }
    public static void displayBookingMenu(){
        boolean check = true;
        while (check){
            System.out.println("Booking Management");
            System.out.println("1. Display List Booking");
            System.out.println("2. Add New Booking");
            System.out.println("3. Edit Booking");
            System.out.println("4. Return Main Menu");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()){
                case 1:
            }
        }
    }
    public static void displayPromotionMenu(){
        boolean check = true;
        while (check){
            System.out.println("Promotion Management");
            System.out.println("1. Display List Promotion");
            System.out.println("2. Add New Promotion");
            System.out.println("3. Edit Promotion");
            System.out.println("4. Return Main Menu");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()){
                case 1:
            }
        }
    }
}
