package demo_quanlyphuongtiengiaothong.servicer;

import demo_quanlyphuongtiengiaothong.controller.PhuongTienController;
import demo_quanlyphuongtiengiaothong.model.OTo;
import demo_quanlyphuongtiengiaothong.model.XeMay;
import demo_quanlyphuongtiengiaothong.repository.OToRepository;
import demo_quanlyphuongtiengiaothong.repository.XeMayRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PhuongTienServiceImpl implements Service{
    OToRepository oToRepository = new OToRepository();
    XeMayRepository xeMayRepository = new XeMayRepository();
    Scanner scanner = new Scanner(System.in);
    List<OTo> oToList = oToRepository.readOToCsv();
    List<XeMay> xeMayList = xeMayRepository.readXeMayCsv();
    PhuongTienController phuongTienController = new PhuongTienController();

    private int generateNextOToID() {
        int maxID = 0;
        for (OTo oTo : oToList) {
            if (oTo.getId() > maxID) {
                maxID = oTo.getId();
            }
        }
        return maxID + 1;
    }

    private int generateNextXeMayID() {
        int maxID = 0;
        for (XeMay xeMay : xeMayList) {
            if (xeMay.getId() > maxID) {
                maxID = xeMay.getId();
            }
        }
        return maxID + 1;
    }

    public boolean validateInput(String input) {
        return !input.isEmpty();
    }
    @Override
    public void add() {
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Danh sach thanh phan \n" +
                        "1. Danh sach o to \n" +
                        "2. Danh sach xe may \n" +
                        "3. Back to menu "
                );
                System.out.println("Chọn chức năng ");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        addOTo();
                        break;
                    case 2:
                        addXeMay();
                        break;
                    case 3:
                        phuongTienController.displayPhuongTienMenu();
                        break;
                }

            } catch (InputMismatchException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();

            } catch (NumberFormatException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            }
        }
    }

    private void addXeMay() {
        XeMay xeMay = new XeMay(0, "74H1-08353", "VietNam", "2023", "XuanBao","110");
        xeMay.setId(generateNextXeMayID());

        System.out.println("Nhập biển số");
        String bienSo = scanner.nextLine();
        while (!validateInput(bienSo)) {
            System.out.println("Biển số không được để trống. Mời bạn nhập lại:");
            bienSo = scanner.nextLine();
        }
        xeMay.setBienSo(bienSo);

        System.out.println("Nhập nhà sản xuất");
        String nhaSanXuat = scanner.nextLine();
        while (!validateInput(nhaSanXuat)) {
            System.out.println("Nhà sản xuất không được để trống. Mời bạn nhập lại:");
            nhaSanXuat = scanner.nextLine();
        }
        xeMay.setNhaSanXuat(nhaSanXuat);

        System.out.println("Nhập năm sản xuất");
        String namSanXuat = scanner.nextLine();
        while (!validateInput(namSanXuat)) {
            System.out.println("Năm sản xuất không được để trống. Mời bạn nhập lại:");
            namSanXuat = scanner.nextLine();
        }
        xeMay.setNamSanXuat(namSanXuat);

        System.out.println("Chủ sở hữu");
        String chuSoHuu = scanner.nextLine();
        while (!validateInput(chuSoHuu)) {
            System.out.println("Chủ sở hữu không được để trống. Mời bạn nhập lại:");
            chuSoHuu = scanner.nextLine();
        }
        xeMay.setChuSoHuu(chuSoHuu);

        System.out.println("Công suất");
        String congSuat = scanner.nextLine();
        while (!validateInput(congSuat)) {
            System.out.println("Công suất không được để trống. Mời bạn nhập lại:");
            congSuat = scanner.nextLine();
        }
        xeMay.setCongSuat(congSuat);

        xeMayList.add(xeMay);
        xeMayRepository.writeXeMayCsv(xeMayList);
        System.out.println("Xe máy đã được thêm mới");
    }


    private void addOTo() {
        OTo oTo = new OTo(0, "74A-08353", "VietNam", "2023", "XuanBao", 5, "Toyota");
        oTo.setId(generateNextOToID());

        System.out.println("Nhập biển số");
        String bienSo = scanner.nextLine();
        while (!validateInput(bienSo)) {
            System.out.println("Biển số không được để trống. Mời bạn nhập lại:");
            bienSo = scanner.nextLine();
        }
        oTo.setBienSo(bienSo);

        System.out.println("Nhập nhà sản xuất");
        String nhaSanXuat = scanner.nextLine();
        while (!validateInput(nhaSanXuat)) {
            System.out.println("Nhà sản xuất không được để trống. Mời bạn nhập lại:");
            nhaSanXuat = scanner.nextLine();
        }
        oTo.setNhaSanXuat(nhaSanXuat);

        System.out.println("Nhập năm sản xuất");
        String namSanXuat = scanner.nextLine();
        while (!validateInput(namSanXuat)) {
            System.out.println("Năm sản xuất không được để trống. Mời bạn nhập lại:");
            namSanXuat = scanner.nextLine();
        }
        oTo.setNamSanXuat(namSanXuat);

        System.out.println("Chủ sở hữu");
        String chuSoHuu = scanner.nextLine();
        while (!validateInput(chuSoHuu)) {
            System.out.println("Chủ sở hữu không được để trống. Mời bạn nhập lại:");
            chuSoHuu = scanner.nextLine();
        }
        oTo.setChuSoHuu(chuSoHuu);

        System.out.println("Số chổ");
        String soChoInput = scanner.nextLine();
        while (soChoInput.isEmpty()) {
            System.out.println("Số chổ không được để trống. Mời bạn nhập lại:");
            soChoInput = scanner.nextLine();
        }
        int soCho = Integer.parseInt(soChoInput);
        oTo.setSoCho(soCho);


        System.out.println("Kiểu xe");
        String kieuXe = scanner.nextLine();
        oTo.setKieuXe(scanner.nextLine());
        while (!validateInput(kieuXe)){
            System.out.println("Kiểu xe không được để trống. Mời bạn nhập lại:");
            kieuXe = scanner.nextLine();
        }

        oToList.add(oTo);
        oToRepository.writeOToCsv(oToList);
        System.out.println("Ô tô đã được thêm mới");
    }

    @Override
    public void update() {
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Danh sach thanh phan \n" +
                        "1. Danh sach o to \n" +
                        "2. Danh sach xe may \n" +
                        "3. Back to menu "
                );
                System.out.println("Chọn chức năng ");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        updateOTo();
                        break;
                    case 2:
                        updateXeMay();
                        break;
                    case 3:
                        phuongTienController.displayPhuongTienMenu();
                        break;
                }

            } catch (InputMismatchException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();

            } catch (NumberFormatException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            }
        }
    }

    private void updateXeMay() {
        System.out.println("Nhập biển số xe máy bạn muốn cập nhật:");
        String bienSoXeMay = scanner.nextLine();
        XeMay xeMayToUpdate = findXeMayByBienSo(bienSoXeMay);

        if (xeMayToUpdate != null) {
            System.out.println("Nhập nhà sản xuất mới");
            xeMayToUpdate.setNhaSanXuat(scanner.nextLine());

            System.out.println("Nhập năm sản xuất mới");
            xeMayToUpdate.setNamSanXuat(scanner.nextLine());

            System.out.println("Nhập chủ sở hữu mới");
            xeMayToUpdate.setChuSoHuu(scanner.nextLine());

            System.out.println("Nhập công suất mới");
            xeMayToUpdate.setCongSuat(scanner.nextLine());

            System.out.println("Thông tin xe máy sau khi cập nhật:");
            System.out.println(xeMayToUpdate.toString());

            for (int i = 0; i < xeMayList.size(); i++) {
                if (xeMayList.get(i).getBienSo().equalsIgnoreCase(bienSoXeMay)) {
                    xeMayList.set(i, xeMayToUpdate);
                    xeMayRepository.writeXeMayCsv(xeMayList);
                    break;
                }
            }
        } else {
            System.out.println("Không tìm thấy xe máy với biển số đã cho.");
        }
    }

    private void updateOTo() {
        System.out.println("Nhập biển số ô tô bạn muốn cập nhật:");
        String bienSoOTo = scanner.nextLine();
        OTo oToToUpdate = findOToByBienSo(bienSoOTo);

        if (oToToUpdate != null) {
            System.out.println("Nhập nhà sản xuất mới");
            oToToUpdate.setNhaSanXuat(scanner.nextLine());

            System.out.println("Nhập năm sản xuất mới");
            oToToUpdate.setNamSanXuat(scanner.nextLine());

            System.out.println("Nhập chủ sở hữu mới");
            oToToUpdate.setChuSoHuu(scanner.nextLine());

            System.out.println("Nhập số chỗ mới");
            int soChoMoi = Integer.parseInt(scanner.nextLine());
            oToToUpdate.setSoCho(soChoMoi);

            System.out.println("Nhập kiểu xe mới");
            oToToUpdate.setKieuXe(scanner.nextLine());

            System.out.println("Thông tin ô tô sau khi cập nhật:");
            System.out.println(oToToUpdate.toString());

            for (int i = 0; i < oToList.size(); i++) {
                if (oToList.get(i).getBienSo().equalsIgnoreCase(bienSoOTo)) {
                    oToList.set(i, oToToUpdate);
                    oToRepository.writeOToCsv(oToList);
                    break;
                }
            }

        } else {
            System.out.println("Không tìm thấy ô tô với biển số đã cho.");
        }
    }

    @Override
    public void display() {
        System.out.println("Danh sach o to:");
        for (OTo oTo : oToList) {
            System.out.println(oTo.toString());
        }

        System.out.println("Danh sach xe may:");
        for (XeMay xeMay : xeMayList) {
            System.out.println(xeMay.toString());
        }
    }

    @Override
    public void delete() {
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Danh sach thanh phan \n" +
                        "1. Danh sach o to \n" +
                        "2. Danh sach xe may \n" +
                        "3. Back to menu "
                );
                System.out.println("Chọn chức năng ");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        deleteOTo();
                        break;
                    case 2:
                        deleteXeMay();
                        break;
                    case 3:
                        phuongTienController.displayPhuongTienMenu();
                        break;
                }

            } catch (InputMismatchException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();

            } catch (NumberFormatException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            }
        }
    }

    private void deleteXeMay() {
        System.out.println("Nhập biển số xe máy bạn muốn xóa:");
        String bienSoXeMay = scanner.nextLine();
        XeMay xeMayToDelete = findXeMayByBienSo(bienSoXeMay);

        if (xeMayToDelete != null) {
            xeMayList.remove(xeMayToDelete);
            xeMayRepository.writeXeMayCsv(xeMayList);
            System.out.println("Xe máy đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy xe máy với biển số đã cho.");
        }
    }

    private void deleteOTo() {
        System.out.println("Nhập biển số ô tô bạn muốn xóa:");
        String bienSoOTo = scanner.nextLine();
        OTo oToToDelete = findOToByBienSo(bienSoOTo);

        if (oToToDelete != null) {
            oToList.remove(oToToDelete);
            oToRepository.writeOToCsv(oToList);
            System.out.println("Ô tô đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy ô tô với biển số đã cho.");
        }
    }

    @Override
    public void serachByName() {
            System.out.println("Nhập tên bạn muốn tìm kiếm:");
            String searchName = scanner.nextLine();

            System.out.println("Kết quả tìm kiếm trong danh sách ô tô:");
            for (OTo oTo : oToList) {
                if (oTo.getChuSoHuu().equalsIgnoreCase(searchName)) {
                    System.out.println(oTo.toString());
                }
            }

            System.out.println("Kết quả tìm kiếm trong danh sách xe máy:");
            for (XeMay xeMay : xeMayList) {
                if (xeMay.getChuSoHuu().equalsIgnoreCase(searchName)) {
                    System.out.println(xeMay.toString());
                }
            }
        }

    private OTo findOToByBienSo(String bienSo) {
        for (OTo oTo : oToList) {
            if (oTo.getBienSo().equals(bienSo)) {
                return oTo;
            }
        }
        return null;
    }
    private XeMay findXeMayByBienSo(String bienSo) {
        for (XeMay xeMay : xeMayList) {
            if (xeMay.getBienSo().equals(bienSo)) {
                return xeMay;
            }
        }
        return null;
    }
}
