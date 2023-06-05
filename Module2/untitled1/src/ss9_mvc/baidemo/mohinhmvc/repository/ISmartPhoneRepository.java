package ss9_mvc.baidemo.mohinhmvc.repository;

import ss9_mvc.baidemo.mohinhmvc.model.SmartPhone;

public interface ISmartPhoneRepository {
    SmartPhone[] getAllSmartphone();
    SmartPhone getSmartphoneById(int id);
    void addSmartphone(SmartPhone smartphone);
    void updateSmartphone(SmartPhone smartphone);
    void deleteSmartphone(int id);
}
