package com.example.quan_ly_book.service;

import java.util.List;

public interface Service<T> {
    List<T> findAll();
    void create(T object);
    void update(T object);
    void delete(String V);
    T findById(int V);
}
