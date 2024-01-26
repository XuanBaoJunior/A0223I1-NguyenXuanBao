package com.example.xe_co.Service;

import com.example.xe_co.Model.San_xuat;

import java.util.List;

public interface ISan_xuatService {
    List<San_xuat> findAll();

    San_xuat findIdSX(int id);

    List<San_xuat> find(int id);
    San_xuat findName(String SXname);
}
