package com.example.baithimd3.Service;

import com.example.baithimd3.Model.PhongTro;

import java.util.List;

public interface IPhongTroService {
    List<PhongTro> findAll();

    PhongTro findIdPT(String id);

    List<PhongTro> find(String id);
}
