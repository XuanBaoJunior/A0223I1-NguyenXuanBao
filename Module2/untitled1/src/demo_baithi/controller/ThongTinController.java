package demo_baithi.controller;

import demo_baithi.servicer.ThongTinServiceImpl;

import java.util.Scanner;

public class ThongTinController {
    public void displayThongTinMenu() {
        ThongTinServiceImpl thongTinService = new ThongTinServiceImpl();
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
                        thongTinService.add();
                        break;
                    case 2:
                        thongTinService.remove();
                        break;
                    case 3:
                        thongTinService.display();
                        break;
                    case 4:
                        thongTinService.update();
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
