package com.example.xe_co.Service;

import com.example.xe_co.Model.Loai_xe;
import com.example.xe_co.Repository.ILoai_xeRepository;
import com.example.xe_co.Repository.Loai_xeRepository;

import java.util.List;

public class Loai_xeService implements ILoai_xeService{
    private ILoai_xeRepository iLoai_xeRepository = new Loai_xeRepository();
    @Override
    public List<Loai_xe> display() {
        return iLoai_xeRepository.display();
    }

    @Override
    public void create(Loai_xe loai_xe) {

    }

    @Override
    public Loai_xe edit(int id_loai_xe) {
        return iLoai_xeRepository.edit(id_loai_xe);
    }

    @Override
    public void update(Loai_xe loai_xe) {
        iLoai_xeRepository.update(loai_xe);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Loai_xe> searchName(String name) {
        return null;
    }
}
