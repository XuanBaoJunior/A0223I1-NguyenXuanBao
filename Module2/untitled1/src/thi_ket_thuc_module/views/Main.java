package thi_ket_thuc_module.views;

import thi_ket_thuc_module.controller.QLDanhBaController;

public class Main {
    public static void main(String[] args) {
        QLDanhBaController qlDanhBaController = new QLDanhBaController();
        qlDanhBaController.displayDanhBaMenu();
    }
}