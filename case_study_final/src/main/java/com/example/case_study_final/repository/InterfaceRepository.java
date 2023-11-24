package com.example.case_study_final.repository;

import java.util.List;

public interface InterfaceRepository<T> {
    List<T> findAll();
    void create(T object);
    void update(T object);
    void delete(int V);
    T findById(int V);
}
