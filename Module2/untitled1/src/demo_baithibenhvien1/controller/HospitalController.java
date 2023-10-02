package demo_baithibenhvien1.controller;

import demo_baithibenhvien1.servicer.HospotalServicerImpl;

import java.util.Scanner;

public class HospitalController {
    public void displayHospotalMenu() {
        HospotalServicerImpl hospotalServicel = new HospotalServicerImpl();
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Chương trình quản lý danh sach");
                System.out.println("1. Thêm thông tin \n" +
                        "2. Xóa thông tin  \n" +
                        "3. Hiển thị danh sách  \n" +
                        "4. Cập nhật thông tin  \n" +
                        "5. Thoát.");
                System.out.println("Chọn chức năng");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        hospotalServicel.add();
                        break;
                    case 2:
                        hospotalServicel.remove();
                        break;
                    case 3:
                        hospotalServicel.display();
                        break;
                    case 4:
                        hospotalServicel.update();
                    case 5:
                        System.exit(0);
                        break;
                }
                check = false;
            } catch (NumberFormatException ex) {
                System.out.println("Mời bạn nhập lại chức năng.");
                scanner.nextLine();
            }
        }
    }
}
