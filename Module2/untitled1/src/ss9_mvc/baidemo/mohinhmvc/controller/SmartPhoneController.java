package ss9_mvc.baidemo.mohinhmvc.controller;

import ss9_mvc.baidemo.mohinhmvc.model.SmartPhone;
import ss9_mvc.baidemo.mohinhmvc.service.SmartPhoneService;

public class SmartPhoneController {
    private SmartPhoneService smartphoneService;

    public SmartPhoneController(SmartPhoneService smartphoneService){
        this.smartphoneService = smartphoneService;
    }
    public void displayAllSmartphone(){
        SmartPhone[] smartphones = smartphoneService.getAllSmartphones();
        if (smartphones.length > 0){
            System.out.println("Danh sach smartphone:");
            for (SmartPhone smartphone : smartphones){
                if (smartphone != null){
                    System.out.println("ID: " + smartphone.getId() + ", Name: " + smartphone.getName() + ", Nuoc san xuat: " + smartphone.getCountry() + ", Thoi gian bao hanh: " + smartphone.getGuarantee() + ", Gia: " + smartphone.getPrice());
                }
            }
        }else {
            System.out.println("Khong tim thay smartphone nao");
        }
    }
    public void addSmartphone(String name, String country, String guarantee, double price){
        SmartPhone smartphone = new SmartPhone(0, name, country, guarantee, price);
        smartphoneService.addSmartphone(smartphone);
        System.out.println("Da them moi smartphone thanh cong");
    }

    public void updateSmartphone(int id, String name, String country, String guarantee, double price){
        SmartPhone smartphone = smartphoneService.getSmartphoneById(id);
        if (smartphone != null){
            smartphone.setName(name);
            smartphone.setCountry(country);
            smartphone.setGuarantee(guarantee);
            smartphone.setPrice(price);
            smartphoneService.updateSmartphone(smartphone);
            System.out.println("Smartphone duoc cap nhat thanh cong");
        }else {
            System.out.println("Khong tim thay smartphone");
        }
    }
    public void deleteSmartphone(int id){
        smartphoneService.deleteSmartphone(id);
        System.out.println("Xoa smartphone thanh cong");
    }
}
