package com.example.baithimd3.Service;

import com.example.baithimd3.Model.PhongTro;
import com.example.baithimd3.Repository.IPhongTroRepository;
import com.example.baithimd3.Repository.PhongTroRepository;

import java.util.List;

public class PhongTroService implements IPhongTroService{
    private IPhongTroRepository iPhongTroRepository = new PhongTroRepository();

    @Override
    public List<PhongTro> findAll() {
        return iPhongTroRepository.findAll();
    }

    @Override
    public PhongTro findIdPT(String id) {
        return iPhongTroRepository.findIdPT(id);
    }

    @Override
    public List<PhongTro> find(String id) {
        return iPhongTroRepository.find(id);
    }
}
