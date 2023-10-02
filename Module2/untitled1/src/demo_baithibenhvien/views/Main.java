package demo_baithibenhvien.views;

import demo_baithibenhvien.controller.HospitalController;

public class Main {
    public static void main(String[] args) {
        HospitalController hospitalController = new HospitalController();
        hospitalController.displayHospotalMenu();
    }
}
