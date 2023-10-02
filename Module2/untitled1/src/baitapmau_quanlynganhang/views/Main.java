package baitapmau_quanlynganhang.views;


import baitapmau_quanlynganhang.controller.TKNganHangController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TKNganHangController tkNganHangController = new TKNganHangController();
        Scanner scanner = new Scanner(System.in);

        boolean check = false;
        while (!check) {
            System.out.println("Chương trình quản lý tài khoản ngân hàng");
            System.out.println("1. Thêm tài khoản \n" +
                    "2. Hiển thị danh sách \n" +
                    "3. Cập nhật \n" +
                    "4. Xóa \n" +
                    "5. Tìm kiếm \n" +
                    "6. Thoát");
            System.out.println("Mời bạn chọn chức năng");

            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    tkNganHangController.add();
                    break;
                case 2:
                    tkNganHangController.display();
                    if (tkNganHangController.isBackToMenu()) {
                        check = false;
                    }
                    break;
                case 3:
                    tkNganHangController.update();
                    break;
                case 4:
                    tkNganHangController.remove();
                    break;
                case 5:
                    tkNganHangController.search();
                    break;
                case 6:
                    check = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, mời nhập lại.");
            }
        }
        scanner.close();
    }
}
