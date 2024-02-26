package com.example.democar.Service;

import com.example.democar.Model.San_xuat;
import com.example.democar.Repository.ISan_xuatRepository;
import com.example.democar.Repository.San_xuatRepository;

import java.util.List;

public class San_xuatService implements ISan_xuatService{
    private ISan_xuatRepository iSan_xuatRepository = new San_xuatRepository();
    @Override
    public List<San_xuat> findAll() {
        return iSan_xuatRepository.findAll();
    }

    @Override
    public San_xuat findIdSX(int id) {
        return iSan_xuatRepository.findIdSX(id);
    }

    @Override
    public List<San_xuat> find(int id) {
        return iSan_xuatRepository.find(id);
    }
}
