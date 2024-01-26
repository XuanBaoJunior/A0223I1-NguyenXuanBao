package com.example.xe_co.Service;

import com.example.xe_co.Model.San_xuat;
import com.example.xe_co.Repository.ISan_xuatRepository;
import com.example.xe_co.Repository.San_xuatRepository;

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

    @Override
    public San_xuat findName(String SXname) {
        return iSan_xuatRepository.findName(SXname);
    }
}
