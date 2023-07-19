package ss20_case_study.controller;

import java.util.Scanner;

public class FuramaController {
    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Furama Resort Management System");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        employeeManagement();
                        break;
                    case 2:
                        customerManagement();
                        break;
                    case 3:
                        facilityManagement();
                        break;
                    case 4:
                        bookingManagement();
                        break;
                    case 5:
                        promotionManagement();
                        break;
                    case 6:
                        System.out.println("Exiting the program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 6);

        scanner.close();
        }

    private void employeeManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Management");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return to main menu");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        displayEmployees();
                        break;
                    case 2:
                        addEmployee();
                        break;
                    case 3:
                        editEmployee();
                        break;
                    case 4:
                        System.out.println("Returning to the main menu...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 4);

        scanner.close();
    }

    private void displayEmployees() {
        System.out.println("Displaying list of employees...");
    }

    private void addEmployee() {
        System.out.println("Adding a new employee...");
    }

    private void editEmployee() {
        System.out.println("Editing an employee...");
    }

    private void customerManagement() {
        System.out.println("Customer Management");
    }

    private void facilityManagement() {
        System.out.println("Facility Management");
    }

    private void bookingManagement() {
        System.out.println("Booking Management");
    }

    private void promotionManagement() {
        System.out.println("Promotion Management");
    }

    public static void main(String[] args) {
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
}
