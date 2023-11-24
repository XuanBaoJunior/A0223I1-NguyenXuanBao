package com.example.quan_ly_bookk.Service.impl;

import com.example.quan_ly_bookk.DTO.TheMuonSachDTO;
import com.example.quan_ly_bookk.Model.TheMuonSach;
import com.example.quan_ly_bookk.Repository.TheMuonSachRepository;
import com.example.quan_ly_bookk.Repository.impl.TheMuonSachRepositoryImpl;
import com.example.quan_ly_bookk.Service.TheMuonSachService;

import java.util.List;

public class TheMuonSachServiceImpl implements TheMuonSachService {
    TheMuonSachRepository theMuonSachRepository = new TheMuonSachRepositoryImpl();
    @Override
    public List<TheMuonSachDTO> findAll() {
        return theMuonSachRepository.findAll();
    }

    @Override
    public void create(TheMuonSach book) {

    }

    @Override
    public void update(TheMuonSach book) {

    }

    @Override
    public void delete(String id) {
        theMuonSachRepository.delete(id);
    }

    @Override
    public List<TheMuonSachDTO> findById(String id) {
        return theMuonSachRepository.findById(id);
    }
}
