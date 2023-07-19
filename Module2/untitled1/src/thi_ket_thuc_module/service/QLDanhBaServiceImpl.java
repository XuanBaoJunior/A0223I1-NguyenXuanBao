package thi_ket_thuc_module.service;

import thi_ket_thuc_module.model.QLDanhBa;
import thi_ket_thuc_module.repository.QLDanhBaRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QLDanhBaServiceImpl implements Service{
    QLDanhBaRepository qlDanhBaRepository = new QLDanhBaRepository();
    Scanner scanner = new Scanner(System.in);
    List<QLDanhBa> qlDanhBaList = qlDanhBaRepository.readDanhBaToFile();
    int nextID = 1;
    @Override
    public void display() {
        qlDanhBaList = qlDanhBaRepository.readDanhBaToFile();
        System.out.println("Quản Lý Danh Bạ");
        System.out.println(qlDanhBaList.toString());
    }

    @Override
    public void add() {
        QLDanhBa qlDanhBa = new QLDanhBa();
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Nhập id");
                qlDanhBa.setId(scanner.nextInt());
                System.out.println("Họ tên");
                scanner.nextLine();
                qlDanhBa.setHoTen(scanner.nextLine());
                System.out.println("Số điện thoại");
                qlDanhBa.setSoDienThoai(scanner.nextLine());
                System.out.println("Địa chỉ ");
                qlDanhBa.setDiaChi(scanner.nextLine());
                System.out.println("Email ");
                qlDanhBa.setEmail(scanner.nextLine());
                System.out.println("Facebook ");
                qlDanhBa.setFacebook(scanner.nextLine());
                boolean flag = false;
                for (int i = 0 ; i < qlDanhBaList.size(); i++){
                    if(qlDanhBaList.get(i).equals(qlDanhBa)){
                        System.out.println("ID đã tồn tại, mời bạn nhập ID khác.");
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    qlDanhBaList.add(qlDanhBa);
                    qlDanhBaRepository.writeDanhBaFileCSV(qlDanhBaList);
                    System.out.println("Danh bạ đã được thêm mới");
                    break;
                }

                check = false;
            } catch (InputMismatchException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();

            } catch (NumberFormatException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void update() {
        System.out.println("Nhập SDT danh bạ cần tìm: ");
        String SoDienThoai = scanner.nextLine();
        QLDanhBa qlDanhBa = null;
        for (int i = 0; i < qlDanhBaList.size(); i++) {
            QLDanhBa qldb = qlDanhBaList.get(i);
            if (qldb.getSoDienThoai().equals(SoDienThoai)) {
                qlDanhBa = qldb;
                break;
            }
        }

        if (qlDanhBa != null) {
            System.out.println("Danh bạ đã được tìm thấy. Nhập thông tin cần cập nhật:");

            System.out.println("Nhập họ tên: ");
            String hoTen = scanner.nextLine();
            qlDanhBa.setHoTen(hoTen);

            System.out.println("Nhập địa chỉ: ");
            String diaChi = scanner.nextLine();
            qlDanhBa.setDiaChi(diaChi);

            System.out.println("Nhập email: ");
            String email = scanner.nextLine();
            qlDanhBa.setEmail(email);

            System.out.println("Nhập Facebook: ");
            String facebook = scanner.nextLine();
            qlDanhBa.setFacebook(facebook);

            System.out.println("Danh bạ đã được cập nhật:");
            System.out.println(qlDanhBa);
        } else {
            System.out.println("Không tìm thấy danh bạ có SDT: " + SoDienThoai);
        }
    }

    //    public void update() {
//        System.out.println("Nhập SDT danh bạ cần tìm: ");
//        String SoDienThoai = scanner.nextLine();
//        QLDanhBa qlDanhBa = null;
//        for (int i = 0; i < qlDanhBaList.size(); i++) {
//            QLDanhBa qldb = qlDanhBaList.get(i);
//            if (qldb.getSoDienThoai().equals(SoDienThoai)) {
//                qlDanhBa = qldb;
//                break;
//            }
//        }
//
//        if (qlDanhBa != null) {
//            System.out.println("Danh ba da duoc cap nhat: ");
//            System.out.println(qlDanhBa);
//        } else {
//            System.out.println("Khong tim thay danh ba co SDT: " + SoDienThoai);
//        }
//    }
    @Override
    public void remove() {
        System.out.println("Nhập SDT danh bạ muốn xóa: ");
        String sdtToDelete = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < qlDanhBaList.size(); i++) {
            QLDanhBa qldb = qlDanhBaList.get(i);
            if (qldb.getSoDienThoai().equals(sdtToDelete)) {
                found = true;
                qlDanhBaList.remove(i);
                qlDanhBaRepository.writeDanhBaFileCSV(qlDanhBaList);
                System.out.println("Danh bạ đã được xóa.");
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy danh bạ có SDT: " + sdtToDelete);
        }
    }
    @Override
    public void serch() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập SDT danh bạ cần tìm: ");
            String SoDienThoai = scanner.nextLine();
            QLDanhBa qlDanhBa = null;
            for (QLDanhBa qldb : qlDanhBaList) {
                if (qldb.getSoDienThoai().equals(SoDienThoai)) {
                    qlDanhBa = qldb;
                    break;
                }
            }
            if (qlDanhBa != null) {
                System.out.println("Tìm thấy danh bạ:");
                System.out.println(qlDanhBa);
            } else {
                System.out.println("Không tìm thấy danh bạ có sdt: " + SoDienThoai);
            }
        }
    }

