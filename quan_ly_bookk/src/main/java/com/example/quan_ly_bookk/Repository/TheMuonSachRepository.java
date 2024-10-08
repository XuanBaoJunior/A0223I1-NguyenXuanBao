package com.example.quan_ly_bookk.Repository;

import com.example.quan_ly_bookk.DTO.TheMuonSachDTO;
import com.example.quan_ly_bookk.Model.TheMuonSach;

import java.util.List;

public interface TheMuonSachRepository {
    List<TheMuonSachDTO> findAll();
    void create(TheMuonSach book);
    void update(TheMuonSach book);
    void delete(String id);
    List<TheMuonSachDTO> findById(String ma_muon);
}
