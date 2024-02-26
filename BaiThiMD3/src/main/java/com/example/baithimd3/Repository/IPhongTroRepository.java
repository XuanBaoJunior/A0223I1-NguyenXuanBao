package com.example.baithimd3.Repository;

import com.example.baithimd3.Model.PhongTro;

import java.util.List;

public interface IPhongTroRepository {
    List<PhongTro> findAll();

    PhongTro findIdPT(String id);

    List<PhongTro> find(String id);
}
