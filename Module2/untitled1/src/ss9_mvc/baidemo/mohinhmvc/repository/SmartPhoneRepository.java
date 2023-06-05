package ss9_mvc.baidemo.mohinhmvc.repository;

import ss9_mvc.baidemo.mohinhmvc.model.SmartPhone;

public class SmartPhoneRepository implements ISmartPhoneRepository {
    private SmartPhone[] smartphones;
    private int nextId;

    public SmartPhoneRepository(){
        smartphones = new SmartPhone[20];
        nextId = 1;
    }
    public SmartPhone[] getAllSmartphones(){
        return smartphones;
    }

    @Override
    public SmartPhone[] getAllSmartphone() {
        return new SmartPhone[0];
    }

    public SmartPhone getSmartphoneById(int id){
        for (SmartPhone smartphone : smartphones){
            if (smartphone != null && smartphone.getId() == id){
                return smartphone;
            }
        }
        return null;
    }

    public void addSmartphone(SmartPhone smartphone){
        smartphone.setId(nextId++);
        for (int i = 0; i < smartphones.length; i++) {
            if (smartphones[i] == null){
                smartphones[i] = smartphone;
                break;
            }
        }
    }
    public void updateSmartphone(SmartPhone smartphone){
        for (int i = 0; i < smartphones.length; i++) {
            if (smartphones[i] != null && smartphones[i].getId()== smartphone.getId()){
                smartphones[i] = smartphone;
                break;
            }
        }
    }
    public void deleteSmartphone(int id){
        for (int i = 0; i < smartphones.length; i++) {
            if (smartphones[i] != null && smartphones[i].getId() == id){
                smartphones[i] = null;
                break;
            }
        }
    }
}
