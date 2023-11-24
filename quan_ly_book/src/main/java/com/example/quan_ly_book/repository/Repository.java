package com.example.quan_ly_book.repository;

import com.example.quan_ly_book.model.Book;

import java.util.List;

public interface Repository<T> {
    List<T>  findAll();
    void create(T object);
    void update(T object);
    void delete(String V);
    T findById(int V);
}
