package com.example.democar.Service;

import com.example.democar.Model.Loai_xe;
import com.example.democar.Repository.ILoai_xeRepository;
import com.example.democar.Repository.Loai_xeRepository;

import java.util.List;

public class Loai_xeService implements ILoai_xeService{
    private ILoai_xeRepository iLoai_xeRepository = new Loai_xeRepository();
    @Override
    public List<Loai_xe> display() {
        return iLoai_xeRepository.display();
    }

    @Override
    public void create(Loai_xe loai_xe) {
        iLoai_xeRepository.create(loai_xe);
    }

    @Override
    public Loai_xe edit(int id) {
        return iLoai_xeRepository.edit(id);
    }

    @Override
    public void update(Loai_xe loai_xe) {
        iLoai_xeRepository.update(loai_xe);
    }

    @Override
    public void delete(int id) {
        iLoai_xeRepository.delete(id);
    }

    @Override
    public List<Loai_xe> searchName(String name) {
        return iLoai_xeRepository.searchName(name);
    }
}
