package com.example.case_study_final.service;

import java.util.List;

public interface InterfaceService<T> {
    List<T> findAll();
    void create(T object);
    void update(T object);
    void delete(int V);
    T findById(int V);
}
