package ss9_mvc.baidemo.mohinhmvc.service;

import ss9_mvc.baidemo.mohinhmvc.model.SmartPhone;
import ss9_mvc.baidemo.mohinhmvc.repository.ISmartPhoneRepository;
import ss9_mvc.baidemo.mohinhmvc.repository.SmartPhoneRepository;

public class SmartPhoneService {
    private SmartPhoneRepository smartphoneRepository;

    public SmartPhoneService(SmartPhoneRepository smartphoneRepository){
        this.smartphoneRepository = smartphoneRepository;
    }
    public SmartPhone[] getAllSmartphones(){
        return smartphoneRepository.getAllSmartphones();
    }
    public SmartPhone getSmartphoneById(int id){
        return smartphoneRepository.getSmartphoneById(id);
    }
    public void addSmartphone(SmartPhone smartphone){
        smartphoneRepository.addSmartphone(smartphone);
    }
    public void updateSmartphone(SmartPhone smartphone){
        smartphoneRepository.updateSmartphone(smartphone);
    }
    public void deleteSmartphone(int id){
        smartphoneRepository.deleteSmartphone(id);
    }
}
