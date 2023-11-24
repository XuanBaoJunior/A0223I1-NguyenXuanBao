package com.example.quan_ly_book.service.impl;

import com.example.quan_ly_book.model.Detail;
import com.example.quan_ly_book.repository.impl.DetailRepository;
import com.example.quan_ly_book.repository.impl.DetailRepositoryImpl;

import java.util.List;

public class DetailServiceImpl implements DetailService{
    private DetailRepository detailRepository = new DetailRepositoryImpl();
    @Override
    public List<Detail> findAll() {
        return null;
    }

    @Override
    public void create(Detail detail) {
        detailRepository.create(detail);
    }

    @Override
    public void update(Detail object) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Detail findById(int id) {
        return null;
    }
}
