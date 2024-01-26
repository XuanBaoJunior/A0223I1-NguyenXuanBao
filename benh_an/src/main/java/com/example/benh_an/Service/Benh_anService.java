package com.example.benh_an.Service;

import com.example.benh_an.Model.Benh_an;
import com.example.benh_an.Repository.Benh_anRepository;

import java.util.List;

public class Benh_anService implements IBenh_anService{
    private Benh_anRepository benh_anRepository = new Benh_anRepository();
    @Override
    public List<Benh_an> display() {
        return benh_anRepository.display();
    }

    @Override
    public Boolean create(Benh_an benh_an) {
        if(benh_an.isValidateReadyInsertDB()){
            return benh_anRepository.create(benh_an);
        } else {
            return false;
        }
    }
}
