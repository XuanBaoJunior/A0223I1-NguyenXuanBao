package thi_ket_thuc_module.controller;

import thi_ket_thuc_module.service.QLDanhBaServiceImpl;

import java.util.Scanner;

public class QLDanhBaController {
    public void displayDanhBaMenu() {
        QLDanhBaServiceImpl qlDanhBaService = new QLDanhBaServiceImpl();
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        while (!check){
            try {
                System.out.println("Chương trình quản lý danh bạ");
                System.out.println("1. Xem danh sách danh bạ \n"+
                        "2. Thêm mới danh bạ \n" +
                        "3. Cập nhật danh bạ \n"+
                        "4. Xóa \n" +
                        "5. Tìm kiếm \n" +
                        "6. Thoát. \n" +
                        "7. Đọc từ file \n" +
                        "8. Ghi vào file");
                System.out.println("Chọn chức năng");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        qlDanhBaService.display();
                        break;
                    case 2:
                        qlDanhBaService.add();
                        break;
                    case 3:
                        qlDanhBaService.update();
                        break;
                    case 4:
                        qlDanhBaService.remove();
                    case 5:
                        qlDanhBaService.serch();
                    case 6:
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
