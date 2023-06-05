package ss9_mvc.baidemo.mohinhmvc.view;

import ss9_mvc.baidemo.mohinhmvc.controller.SmartPhoneController;
import ss9_mvc.baidemo.mohinhmvc.model.SmartPhone;
import ss9_mvc.baidemo.mohinhmvc.repository.ISmartPhoneRepository;
import ss9_mvc.baidemo.mohinhmvc.repository.SmartPhoneRepository;
import ss9_mvc.baidemo.mohinhmvc.service.SmartPhoneService;

import java.util.Scanner;

public class Main {
    private static final int OPTION_DISPLAY_ALL = 1;
    private static final int OPTION_ADD = 2;
    private static final int OPTION_UPDATE = 3;
    private static final int OPTION_DELETE = 4;
    private static final int OPTION_EXIT = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartPhone smartphone1 = new SmartPhone(0, "Samsung", "Korea", "6 Thang", 10000);
        SmartPhone smartphone2 = new SmartPhone(0, "Iphone", "US", "6 Thang", 10000);
        SmartPhone smartphone3 = new SmartPhone(0, "Oppo", "Korea", "6 Thang", 10000);
        SmartPhone smartphone4 = new SmartPhone(0, "Vertu", "Korea", "6 Thang", 800000);

        ISmartPhoneRepository smartphoneRepository = new SmartPhoneRepository();
        smartphoneRepository.addSmartphone(smartphone1);
        smartphoneRepository.addSmartphone(smartphone2);
        smartphoneRepository.addSmartphone(smartphone3);
        smartphoneRepository.addSmartphone(smartphone4);

        SmartPhoneService smartPhoneService = new SmartPhoneService((SmartPhoneRepository) smartphoneRepository);
        SmartPhoneController smartPhoneController = new SmartPhoneController(smartPhoneService);

        int option = 0;
        while (option != OPTION_EXIT){
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case OPTION_DISPLAY_ALL:
                    smartPhoneController.displayAllSmartphone();
                    break;
                case OPTION_ADD:
                    System.out.println("Nhap ten smartphone: ");
                    String name = scanner.nextLine();
                    System.out.println("Nhap nuoc san xuat: ");
                    String country = scanner.nextLine();
                    System.out.println("Nhap thoi gian bao hanh: ");
                    String guarantee = scanner.nextLine();
                    System.out.println("Nhap gia: ");
                    Double price = scanner.nextDouble();
                    smartPhoneController.addSmartphone(name, country, guarantee, price);
                    break;
                case OPTION_UPDATE:
                    System.out.println("Nhap ID smartphone: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhap ten smartphone: ");
                    name = scanner.nextLine();
                    System.out.println("Nhap nuoc san xuat: ");
                    country = scanner.nextLine();
                    System.out.println("Nhap thoi gian bao hanh: ");
                    guarantee = scanner.nextLine();
                    System.out.println("Nhap gia: ");
                    price = scanner.nextDouble();
                    scanner.nextLine();
                    smartPhoneController.updateSmartphone(id ,name, country, guarantee, price);
                    break;
                case OPTION_DELETE:
                    System.out.println("Nhap ID smartphone can xoa: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    smartPhoneController.deleteSmartphone(id);
                    break;
                case OPTION_EXIT:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Tuy chon khong hop le.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Hệ thống quản lý smartphone");
        System.out.println("-------------------------");
        System.out.println("1. Hiển thị tất cả smartphone");
        System.out.println("2. Thêm mới một smartphone");
        System.out.println("3. Cập nhật một smartphone theo ID");
        System.out.println("4. Xóa một smartphone theo ID");
        System.out.println("5. Thoát");
        System.out.print("Nhập một tùy chọn của bạn: ");
    }
}
