package demo_quanlyphuongtiengiaothong.controller;


import demo_quanlyphuongtiengiaothong.servicer.PhuongTienServiceImpl;

import java.util.Scanner;

public class PhuongTienController {
    public void displayPhuongTienMenu() {
        PhuongTienServiceImpl phuongTienService = new PhuongTienServiceImpl();
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Chương trình quản lý danh sach");
                System.out.println("1. Thêm thông tin \n" +
                        "2. Cập nhật thông tin  \n" +
                        "3. Hiển thị danh sách  \n" +
                        "4. Xóa thông tin  \n" +
                        "5. Tìm kiếm theo tên  \n" +
                        "6. Thoát.");
                System.out.println("Chọn chức năng");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        phuongTienService.add();
                        break;
                    case 2:
                        phuongTienService.update();
                        break;
                    case 3:
                        phuongTienService.display();
                        break;
                    case 4:
                        phuongTienService.delete();
                        break;
                    case 5:
                        phuongTienService.serachByName();
                        break;
                    case 6:
                        System.exit(0);
                }
                check = false;
            } catch (NumberFormatException ex) {
                System.out.println("Mời bạn nhập lại chức năng.");
                scanner.nextLine();
            }
        }
    }
}
