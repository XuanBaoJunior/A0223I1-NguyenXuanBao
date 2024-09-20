package com.example.ss5demo.repositories.impl;

import com.example.ss5demo.models.LoaiXe;
import com.example.ss5demo.models.SanXuat;
import com.example.ss5demo.repositories.ISanXuatRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SanXuatRepository implements ISanXuatRepository {
    @Override
    public List<SanXuat> findAll() {
        List<SanXuat> list = BaseRepository.entityManager.createQuery("select s from san_xuat s",SanXuat.class).getResultList();
        return list;
    }
}
