package com.example.quan_ly_book.repository.impl;

import com.example.quan_ly_book.model.The_muon_sach;
import com.example.quan_ly_book.repository.Repository;

public interface The_muon_sachRepository extends Repository<The_muon_sach> {
    The_muon_sach findByIDSach(String id,String bookId, String studentId);
}
