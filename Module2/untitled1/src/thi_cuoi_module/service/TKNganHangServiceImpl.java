package thi_cuoi_module.service;

import thi_cuoi_module.controller.TKNganHangController;
import thi_cuoi_module.model.TKThanhToan;
import thi_cuoi_module.model.TKTietKiem;
import thi_cuoi_module.repository.TKThanhToanRepository;
import thi_cuoi_module.repository.TKTietKiemRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TKNganHangServiceImpl implements Service{

    TKThanhToanRepository tkThanhToanRepository = new TKThanhToanRepository();
    TKTietKiemRepository tkTietKiemRepository = new TKTietKiemRepository();
    Scanner scanner = new Scanner(System.in);
    List<TKThanhToan> tkThanhToanList = tkThanhToanRepository.readTKThanhToanToFile();
    List<TKTietKiem> tkTietKiemList = tkTietKiemRepository.readTKTietKiemToFile();
    TKNganHangController tkNganHangController = new TKNganHangController();
    int nextID = 1;
    @Override
    public void display() {
        tkThanhToanList = tkThanhToanRepository.readTKThanhToanToFile();
        tkTietKiemList = tkTietKiemRepository.readTKTietKiemToFile();
        System.out.println("Tài khoản thanh toán");
        for (TKThanhToan tkttList: tkThanhToanList){
            System.out.println(tkttList.toString());
        }
        System.out.println("Tài khoản tiết kiệm");
        for (TKTietKiem tktkList: tkTietKiemList) {
            System.out.println(tktkList.toString());
        }
    }

    @Override
    public void add() {
        boolean check = false;
        while (!check){
            try {
                System.out.println("Danh sách tài khoản thanh toán \n" +
                        "1. Tài khoản thanh toán \n"+
                        "2. Tài khoản tiết kiệm\n"+
                        "3. Quay trở lại menu.");
                System.out.println("Chọn chức năng");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        addTKThanhToan();
                        break;
                    case 2:
                        addTKTietKiem();
                        break;
                    case 3:
                        tkNganHangController.displayNganHangMenu();
                        break;
                }
            }catch (InputMismatchException ex){
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            }catch (NumberFormatException ex){
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            }
        }
    }

    private void addTKTietKiem() {
        TKTietKiem tkTietKiem = new TKTietKiem();
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Nhập id");
                tkTietKiem.setId(scanner.nextInt());
                System.out.println("Tên khách hàng");
                scanner.nextLine();
                tkTietKiem.setMaTaiKhoan(scanner.nextLine());
                System.out.println("Nhập mã tài khoản");
                tkTietKiem.setTenChuTaiKhoan(scanner.nextLine());
                System.out.println("Nhập tên chủ tk ");
                tkTietKiem.setNgayTaoTk(scanner.nextLine());
                System.out.println("Ngày tạo tk ");
                tkTietKiem.setSoTienGuiTietKiem(scanner.nextLine());
                System.out.println("Số tiền gửi tk ");
                tkTietKiem.setNgayGuiTietKiem(scanner.nextLine());
                System.out.println("Ngày gửi tk ");
                tkTietKiem.setKyHan(scanner.nextLine());
                System.out.println("Kỳ hạn");
                tkTietKiem.setLaiSuat(scanner.nextLine());
                boolean flag = false;
                for (int i = 0 ; i < tkTietKiemList.size(); i++){
                    if(tkTietKiemList.get(i).equals(tkTietKiem)){
                        System.out.println("ID đã tồn tại, mời bạn nhập ID khác.");
                        flag = true;
                        break;
                    }

                }
                if(!flag){
                    tkTietKiemList.add(tkTietKiem);
                    tkTietKiemRepository.writeTKTietKiemFileCSV(tkTietKiemList);
                    System.out.println("Tài khoản ngân hàng đã được thêm mới");

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

    private void addTKThanhToan() {
        TKThanhToan tkThanhToan = new TKThanhToan();
        boolean check = false;
        while (!check){
            try{
                System.out.println("Nhập id");
                tkThanhToan.setId(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Mã tài khoản");
                tkThanhToan.setMaTaiKhoan(scanner.nextLine());
                System.out.println("Tên chủ tk");
                tkThanhToan.setTenChuTaiKhoan(scanner.nextLine());
                System.out.println("Ngày tạo tk ");
                tkThanhToan.setNgayTaoTk(scanner.nextLine());
                System.out.println("số thẻ ");
                tkThanhToan.setSoThe(scanner.nextLine());
                System.out.println("số tiền trong thẻ");
                tkThanhToan.setSoTienTrongTaiKhoan(scanner.nextLine());

                tkThanhToanList.add(tkThanhToan);
                tkThanhToanRepository.writeTKThanhToanFileCSV(tkThanhToanList);

                check = false;
                break;
            }catch (InputMismatchException ex) {
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
        System.out.println("Nhập mã cần tìm");
        int ten = scanner.nextInt();
        TKThanhToan tkThanhToan = null;
        for (int i = 0; i < tkThanhToanList.size(); i++){
            TKThanhToan tktt = tkThanhToanList.get(i);
            if (tktt.getId() == ten){
                tkThanhToan = tktt;
                System.out.println(tkThanhToan);
            }
        }
    }

    @Override
    public void remove() {
        System.out.println("Loại tài khoản ngân hàng muốn xóa \n" +
                "1.Tài khoản thanh toán \n" +
                "2.Tài khoản tiết kiệm ");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                System.out.println("Nhập id cần xoá ");
                int ten = scanner.nextInt();
                TKThanhToan tkThanhToan = null;
                for (int i = 0; i < tkThanhToanList.size(); i++) {
                    TKThanhToan tktt = tkThanhToanList.get(i);
                    if (tktt.getId()== ten) {
                        tkThanhToan = tktt;
                        tkThanhToanList.remove(tkThanhToan);
                        tkThanhToanRepository.writeTKThanhToanFileCSV(tkThanhToanList);
                    }
                }
                break;
            case 2:
                System.out.println("Nhập id  cần xoá ");
                int tenTK = scanner.nextInt();
                TKTietKiem tkTietKiem = null;
                for (int i = 0; i < tkTietKiemList.size(); i++) {
                    TKTietKiem tktk = tkTietKiemList.get(i);
                    if (tktk.getId() == tenTK) {
                        tkTietKiem = tktk;
                        tkTietKiemList.remove(tkTietKiem);
                        tkTietKiemRepository.writeTKTietKiemFileCSV(tkTietKiemList);
                    }
                }
                break;

        }
    }
}
