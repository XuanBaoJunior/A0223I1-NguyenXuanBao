package com.example.baithi.Repository;

import com.example.baithi.Model.The_muon_sach;

import java.util.List;

public interface The_muon_sachRepository {
    List<The_muon_sach> findAll();
    void create(The_muon_sach the_muon_sach);
    void update(The_muon_sach the_muon_sach);
    void delete(String id);
    The_muon_sach findById(int id);
    The_muon_sach findByIDSach(String id, String bookId, String studentId);
}
