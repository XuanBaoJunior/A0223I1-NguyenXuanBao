package com.example.ss5demo.repositories;

import com.example.ss5demo.models.LoaiXe;

import java.util.List;

public interface ILoaiXeRepository {
    List<LoaiXe> findAll();
    void save(LoaiXe loaiXe);

    List<LoaiXe> findOneByID(Integer code);
}
