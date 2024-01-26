package com.example.benh_an.Service;

import com.example.benh_an.Model.Benh_nhan;

import java.util.List;

public interface IBenh_nhanService {

    List<Benh_nhan> findAll();

    String getNameBN(String id_benh_nhan);
}
