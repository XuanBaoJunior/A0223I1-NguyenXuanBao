package com.example.ss5demo.services.impl;

import com.example.ss5demo.models.SanXuat;
import com.example.ss5demo.repositories.ISanXuatRepository;
import com.example.ss5demo.services.ISanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanXuatService implements ISanXuatService {
    @Autowired
    private ISanXuatRepository sanXuatRepository;

    @Override
    public List<SanXuat> findAll() {
        return sanXuatRepository.findAll();
    }
}
