package com.example.quan_ly_book.service.impl;

import com.example.quan_ly_book.model.The_muon_sach;
import com.example.quan_ly_book.repository.impl.The_muon_sachRepository;
import com.example.quan_ly_book.repository.impl.The_muon_sachRepositoryImpl;

import java.util.List;

public class The_muon_sachServiceImpl implements The_muon_sachService{
    private The_muon_sachRepository theMuonSachRepository = new The_muon_sachRepositoryImpl();
    @Override
    public List<The_muon_sach> findAll() {
        return theMuonSachRepository.findAll();
    }

    @Override
    public void create(The_muon_sach the_muon_sach) {
        theMuonSachRepository.create(the_muon_sach);
    }

    @Override
    public void update(The_muon_sach the_muon_sach) {
        theMuonSachRepository.update(the_muon_sach);
    }

    @Override
    public void delete(String id) {
        theMuonSachRepository.delete(id);
    }

    @Override
    public The_muon_sach findById(int id) {
        return null;
    }

    @Override
    public The_muon_sach findByIDSach(String id, String bookId, String studentId) {
        return theMuonSachRepository.findByIDSach(id, bookId, studentId);
    }
}
