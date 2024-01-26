package com.example.benh_an.Service;

import com.example.benh_an.Model.Benh_nhan;
import com.example.benh_an.Repository.Benh_nhanRepository;

import java.util.List;

public class Benh_nhanService implements IBenh_nhanService{
    private Benh_nhanRepository benh_nhanRepository = new Benh_nhanRepository();
    @Override
    public List<Benh_nhan> findAll() {
        return benh_nhanRepository.findAll();
    }

    @Override
    public String getNameBN(String id_benh_nhan) {
        return benh_nhanRepository.getNameBN(id_benh_nhan);
    }
}
