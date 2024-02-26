package com.example.democar.Service;

import com.example.democar.Model.San_xuat;

import java.util.List;

public interface ISan_xuatService {
    List<San_xuat> findAll();

    San_xuat findIdSX(int id);

    List<San_xuat> find(int id);
}
