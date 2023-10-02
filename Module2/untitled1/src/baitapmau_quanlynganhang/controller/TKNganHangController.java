package baitapmau_quanlynganhang.controller;

import baitapmau_quanlynganhang.servicer.TKNganHangServicerImlp;

import java.util.Scanner;

public class TKNganHangController {
    private TKNganHangServicerImlp tkNganHangServicer;
    private Scanner scanner;
    public boolean isBackToMenu() {
        return tkNganHangServicer.isBackToMenu();
    }

    public TKNganHangController(){
        tkNganHangServicer = new TKNganHangServicerImlp();
        scanner = new Scanner(System.in);
    }
    public void add() {
        tkNganHangServicer.add();
    }
    public void display() {
        tkNganHangServicer.display();
    }
    public void update() {
        tkNganHangServicer.update();
    }
    public void remove() {
        tkNganHangServicer.remove();
    }
    public void search() {
        tkNganHangServicer.search();
    }
}
