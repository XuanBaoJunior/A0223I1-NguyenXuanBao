package BaiTap_QuanLyDienThoai.service;

import BaiTap_QuanLyDienThoai.model.QLDienThoai;
import BaiTap_QuanLyDienThoai.repository.QLDienThoaiRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QLDienThoaiServicerImpl implements Servicer {

    QLDienThoaiRepository qlDienThoaiRepository = new QLDienThoaiRepository();
    Scanner scanner = new Scanner(System.in);
    List<QLDienThoai> qlDienThoaiList = qlDienThoaiRepository.readDienThoaiToFile();

    private int generateNextQLDienThoaiID() {
        int maxID = 0;
        for (QLDienThoai qlDienThoai : qlDienThoaiList) {
            if (qlDienThoai.getId() > maxID) {
                maxID = qlDienThoai.getId();
            }
        }
        return maxID + 1;
    }

    private static double getValidPrice() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Nhập giá (phải lớn hơn 50 đồng): ");
            String input = scanner.nextLine();

            try {
                double price = Double.parseDouble(input);

                if (price > 50.0) {
                    return price;
                } else {
                    System.out.println("Giá không hợp lệ. Giá phải lớn hơn 50 đồng. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    private boolean isValidName(String name) {
            return name.matches("^(.+$|[A-Za-z\\s]+)$");
    }

    public static String getValidProducer(Scanner scanner) {
        String nhaSanXuat;
        do {
            System.out.println("Nhập nhà sản xuất: ");
            nhaSanXuat = scanner.nextLine();
            if (nhaSanXuat.isEmpty()) {
                System.out.println("Bạn chưa nhập nhà sản xuất. Vui lòng nhập lại.");
            }
        } while (nhaSanXuat.isEmpty());

        return nhaSanXuat;
    }
    @Override
    public void add() {
        QLDienThoai qlDienThoai = new QLDienThoai();
        qlDienThoai.setId(generateNextQLDienThoaiID());

        System.out.println("Nhập tên điện thoại: ");
        String nameSmartPhone = scanner.nextLine();
        while (!isValidName(nameSmartPhone)){
            System.out.println("Tên không hợp lệ vui lòng nhập lại");
            nameSmartPhone = scanner.nextLine();
        }
        qlDienThoai.setName(nameSmartPhone);

        double priceSmartPhone = getValidPrice();
        qlDienThoai.setPrice(priceSmartPhone);

        String nhaSanXuat = getValidProducer(scanner);
        qlDienThoai.setProducer(nhaSanXuat);

        qlDienThoaiList.add(qlDienThoai);
        qlDienThoaiRepository.writeDienThoaiCSV(qlDienThoaiList);
        System.out.println("Điện thoại đã được thêm mới");
    }

    @Override
    public void display() {
        qlDienThoaiList = qlDienThoaiRepository.readDienThoaiToFile();
        System.out.println("Danh sách điện thoại");
        for (QLDienThoai dtList : qlDienThoaiList){
            System.out.println(dtList.toString());
        }
    }

    @Override
    public void remove() {
        while (true) {
            System.out.println("Nhập ID bạn muốn xóa (hoặc nhập 0 để thoát): ");
            int idRemove = scanner.nextInt();
            scanner.nextLine();

            if (idRemove == 0) {
                System.out.println("Thoát khỏi chức năng xóa.");
                break;
            }

            boolean found = false;
            for (Iterator<QLDienThoai> iterator = qlDienThoaiList.iterator(); iterator.hasNext();) {
                QLDienThoai qlDienThoai = iterator.next();
                if (qlDienThoai.getId() == idRemove) {
                    iterator.remove();
                    qlDienThoaiRepository.writeDienThoaiCSV(qlDienThoaiList);
                    System.out.println("Điện thoại đã được xóa");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Không tìm thấy điện thoại có ID: " + idRemove);
            }
        }
    }


    @Override
    public void search() {
        boolean continueSearching = true;

        while (continueSearching) {
            System.out.println("Nhập ID bạn muốn tìm kiếm hoặc nhập '0' để thoát: ");
            int idToSearch = scanner.nextInt();
            scanner.nextLine();

            if (idToSearch == 0) {
                continueSearching = false;
                System.out.println("Đã thoát khỏi tìm kiếm.");
            } else {
                boolean found = false;
                for (QLDienThoai qlDienThoai : qlDienThoaiList) {
                    if (qlDienThoai.getId() == idToSearch) {
                        System.out.println("Thông tin điện thoại có ID " + idToSearch + ":");
                        System.out.println(qlDienThoai.toString());
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Không tìm thấy điện thoại có ID: " + idToSearch);
                }
            }
        }
    }

}
