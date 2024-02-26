package com.example.democar.Repository;

import com.example.democar.Model.San_xuat;

import java.util.List;

public interface ISan_xuatRepository {
    List<San_xuat> findAll();

    San_xuat findIdSX(int id);

    List<San_xuat> find(int id);
}
