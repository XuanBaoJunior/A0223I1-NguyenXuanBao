package BaiTap_QuanLyDienThoai.controller;

import BaiTap_QuanLyDienThoai.service.QLDienThoaiServicerImpl;

import java.util.Scanner;

public class QLDienThoaiController {
    private QLDienThoaiServicerImpl qlDienThoaiServicer;
    private Scanner scanner;

    public QLDienThoaiController() {
        qlDienThoaiServicer = new QLDienThoaiServicerImpl();
        scanner = new Scanner(System.in);
    }

    public void add() {
        // Thực hiện thêm điện thoại vào danh sách bằng cách gọi phương thức từ qlDienThoaiServicer
        qlDienThoaiServicer.add();
    }

    public void display() {
        // Hiển thị danh sách điện thoại bằng cách gọi phương thức từ qlDienThoaiServicer
        qlDienThoaiServicer.display();
    }

    public void remove() {
        // Thực hiện xóa điện thoại khỏi danh sách bằng cách gọi phương thức từ qlDienThoaiServicer
        qlDienThoaiServicer.remove();
    }

    public void search() {
        // Thực hiện tìm kiếm điện thoại trong danh sách bằng cách gọi phương thức từ qlDienThoaiServicer
        qlDienThoaiServicer.search();
    }
}