package com.example.ss5demo.services.impl;

import com.example.ss5demo.models.LoaiXe;
import com.example.ss5demo.repositories.ILoaiXeRepository;
import com.example.ss5demo.services.ILoaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiXeService implements ILoaiXeService {
    @Autowired
    private ILoaiXeRepository loaiXeRepository;

    @Override
    public List<LoaiXe> findAll() {
        return loaiXeRepository.findAll();
    }

    @Override
    public void save(LoaiXe loaiXe) {
        loaiXeRepository.save(loaiXe);
    }

    @Override
    public List<LoaiXe> findOneByID(Integer code) {
        return loaiXeRepository.findOneByID(code);
    }
}
