package com.example.quan_ly_book.service.impl;

import com.example.quan_ly_book.model.The_muon_sach;
import com.example.quan_ly_book.service.Service;

public interface The_muon_sachService extends Service<The_muon_sach> {
    The_muon_sach findByIDSach(String id,String bookId, String studentId);
}
