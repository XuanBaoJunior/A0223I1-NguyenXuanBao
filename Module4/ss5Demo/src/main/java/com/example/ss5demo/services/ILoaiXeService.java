package com.example.ss5demo.services;

import com.example.ss5demo.models.LoaiXe;

import java.util.List;

public interface ILoaiXeService {
    List<LoaiXe> findAll();
    void save(LoaiXe loaiXe);

    List<LoaiXe> findOneByID(Integer code);
}
