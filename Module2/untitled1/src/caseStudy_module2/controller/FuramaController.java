package caseStudy_module2.controller;

import java.util.Scanner;

public class FuramaController {
    public void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        while (check){
            try {
                System.out.println("Chương trình quản lý khu nghỉ dưỡng Furama");
                System.out.println("1. Employee Management: \n" +
                        "2. Customer Management: \n" +
                        "3. Facility Management: \n" +
                        "4. Booking Management: \n" +
                        "5. Promotion Management: \n" +
                        "6. Exit");
                System.out.println("Mời bạn chọn chức năng");

            }catch (NumberFormatException e){
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            }

        }
    }
}
