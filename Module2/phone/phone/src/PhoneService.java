import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneService {
    private List<AuthenticPhone> authenticPhones = new ArrayList<>();
    private List<HandPhone> handPhones = new ArrayList<>();


    public List<AuthenticPhone> findAllAuthentic(){
        return authenticPhones;
    }

    public List<HandPhone> findAllHand(){
        return handPhones;
    }

    public void save(Phone phone){
        if(phone.getId() > 0){
            if (phone instanceof AuthenticPhone a) {
                for (int i = 0; i < authenticPhones.size(); i++) {
                    if (authenticPhones.get(i).getId() == a.getId()) {
                        authenticPhones.set(i, a);
                        break;
                    }
                }
            }

            if (phone instanceof HandPhone h) {
                for (int i = 0; i < handPhones.size(); i++) {
                    if (handPhones.get(i).getId() == h.getId()) {
                        handPhones.set(i, h);
                        break;
                    }
                }
            }
        }
        else {
            int lastId = 0;

            if (phone instanceof AuthenticPhone a) {
                if (!authenticPhones.isEmpty()) {
                    lastId = authenticPhones.get(authenticPhones.size() - 1).getId();
                }

                a.setId(lastId + 1);
                authenticPhones.add(a);
            }

            if (phone instanceof HandPhone h) {
                if (!handPhones.isEmpty()) {
                    lastId = handPhones.get(handPhones.size() - 1).getId();
                }

                h.setId(lastId + 1);
                handPhones.add(h);
            }
        }
    }

//    public void create(Phone phone){
//        int lastId = 0;
//
//        if(phone instanceof AuthenticPhone a){
//            if(!authenticPhones.isEmpty()){
//                lastId = authenticPhones.get(authenticPhones.size()-1).getId();
//            }
//
//            a.setId(lastId + 1);
//            authenticPhones.add(a);
//        }
//
//        if (phone instanceof HandPhone h){
//            if(!handPhones.isEmpty()){
//                lastId = handPhones.get(handPhones.size()-1).getId();
//            }
//
//            h.setId(lastId + 1);
//            handPhones.add(h);
//        }
//    }
//
//    public void update(Phone phone){
//        if(phone instanceof AuthenticPhone a){
//            for (int i = 0; i < authenticPhones.size(); i++) {
//                if(authenticPhones.get(i).getId() == a.getId()){
//                    authenticPhones.set(i, a);
//                    break;
//                }
//            }
//        }
//
//        if(phone instanceof HandPhone h){
//            for (int i = 0; i < handPhones.size(); i++) {
//                if(handPhones.get(i).getId() == h.getId()){
//                    handPhones.set(i,h);
//                    break;
//                }
//            }
//        }
//    }

    public void deleteById(boolean isAuthentic, int id){
        if(isAuthentic){
            authenticPhones.removeIf(e -> e.getId() == id);
        }
        else {
            handPhones.removeIf(e -> e.getId() == id);
        }
    }

    public List<Phone> findByPrice(boolean isAuthentic, Double price){
//        if(isAuthentic){
//            return authenticPhones.stream().filter(e-> e.getPrice().equals(price)).collect(Collectors.toList());
//        }
//
//        return handPhones.stream().filter(e-> e.getPrice().equals(price)).collect(Collectors.toList());

        if(isAuthentic){
            List<Phone> result = new ArrayList<>();

            for (int i = 0; i < authenticPhones.size(); i++) {
                if(authenticPhones.get(i).getPrice().equals(price)){
                    result.add(authenticPhones.get(i));
                }
            }

            return result;
        }

        List<Phone> result = new ArrayList<>();
        for (int i = 0; i < handPhones.size(); i++) {
            if(handPhones.get(i).getPrice().equals(price)){
                result.add(handPhones.get(i));
            }
        }

        return result;
    }
}
