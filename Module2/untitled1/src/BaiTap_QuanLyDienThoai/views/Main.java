package BaiTap_QuanLyDienThoai.views;

import BaiTap_QuanLyDienThoai.controller.QLDienThoaiController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QLDienThoaiController qlDienThoaiController = new QLDienThoaiController();
        Scanner scanner = new Scanner(System.in);

        boolean check = false;
        while (!check) {
            System.out.println("Chương trình quản lý danh sách điện thoại");
            System.out.println("1. Thêm điện thoại \n" +
                    "2. Hiển thị danh sách \n" +
                    "3. Xóa điện thoại \n" +
                    "4. Tìm kiếm \n" +
                    "5. Thoát");
            System.out.println("Mời bạn chọn chức năng");

            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    qlDienThoaiController.add();
                    break;
                case 2:
                    qlDienThoaiController.display();
                    break;
                case 3:
                    qlDienThoaiController.remove();
                    break;
                case 4:
                    qlDienThoaiController.search();
                    break;
                case 5:
                    check = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, mời nhập lại.");
            }
        }
    }
}