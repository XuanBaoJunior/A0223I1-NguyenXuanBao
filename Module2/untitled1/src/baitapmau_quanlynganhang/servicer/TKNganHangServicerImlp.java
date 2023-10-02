package baitapmau_quanlynganhang.servicer;

import baitapmau_quanlynganhang.model.TKTietKiem;
import baitapmau_quanlynganhang.model.TKTinDung;
import baitapmau_quanlynganhang.repository.TKTietKiemRepository;
import baitapmau_quanlynganhang.repository.TKTinDungRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TKNganHangServicerImlp implements Servicer{

    TKTietKiemRepository tkTietKiemRepository = new TKTietKiemRepository();
    TKTinDungRepository tkTinDungRepository = new TKTinDungRepository();
    Scanner scanner = new Scanner(System.in);
    List<TKTietKiem> tkTietKiemList = tkTietKiemRepository.readTKTietKiemToFile();
    List<TKTinDung> tkTinDungList = tkTinDungRepository.readTKTinDungToFile();

    private int generateNextTKTietKiemID() {
        int maxID = 0;
        for (TKTietKiem tietKiem : tkTietKiemList) {
            if (tietKiem.getId() > maxID) {
                maxID = tietKiem.getId();
            }
        }
        return maxID + 1;
    }
    private int generateNextTKTinDungID() {
        int maxID = 0;
        for (TKTinDung tinDung : tkTinDungList) {
            if (tinDung.getId() > maxID) {
                maxID = tinDung.getId();
            }
        }
        return maxID + 1;
    }
    private boolean backToMenu = false;
    @Override
    public void add() {
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Danh sach thanh phan \n" +
                        "1. Danh sach tai khoan tiet kiem \n" +
                        "2. Danh sach tai khoan tin dung \n" +
                        "3. Back to menu "
                );
                System.out.println("Chọn chức năng ");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        addTKTietKiem();
                        break;
                    case 2:
                        addTKTinDung();
                        break;
                    case 3:
                        backToMenu = true;
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

    private void addTKTietKiem() {
    }

    private void addTKTinDung() {
    }

    public boolean isBackToMenu() {
        return backToMenu;
    }

    @Override
    public void display() {

    }

    @Override
    public void update() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void search() {

    }
}
