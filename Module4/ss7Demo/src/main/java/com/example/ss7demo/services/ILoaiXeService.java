package com.example.ss7demo.services;

import com.example.ss7demo.models.LoaiXe;

import java.util.List;

public interface ILoaiXeService {
    List<LoaiXe> findAll();

    void save(LoaiXe loaiXe);

    List<LoaiXe> findAllByName(String name);

    void deleteById(Integer code);
}
