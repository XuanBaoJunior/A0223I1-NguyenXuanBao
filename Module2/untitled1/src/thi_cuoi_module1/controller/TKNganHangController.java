package thi_cuoi_module1.controller;

import thi_cuoi_module1.service.TKNganHangServiceImpl;

import java.util.Scanner;

public class TKNganHangController {
    public void displayNganHangMenu(){
        TKNganHangServiceImpl tkNganHangService = new TKNganHangServiceImpl();
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        while (!check){
            try {
                System.out.println("Chương trình quản lý tài khoản ngân hàng");
                System.out.println("1. Thêm mới một tài khoản ngân hàng \n"+
                        "2. Xóa tài khoản \n" +
                        "3. Xem danh sách các tài khoản ngân hàng \n"+
                        "4. Tìm kiếm tài khoản ngân hàng \n" +
                        "5. Thoát.");
                System.out.println("Chọn chức năng");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        tkNganHangService.add();
                        break;
                    case 2:
                        tkNganHangService.remove();
                        break;
                    case 3:
                        tkNganHangService.display();
                        break;
                    case 4:
                        tkNganHangService.update();
                    case 5:
                        System.exit(0);
                        break;
                }
                check = false;
            }catch (NumberFormatException ex){
                System.out.println("Mời bạn nhập lại chức năng.");
                scanner.nextLine();
            }
        }
    }
}
