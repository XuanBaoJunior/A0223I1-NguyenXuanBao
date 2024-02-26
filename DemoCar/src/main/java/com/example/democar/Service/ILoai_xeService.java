package com.example.democar.Service;

import com.example.democar.Model.Loai_xe;

import java.util.List;

public interface ILoai_xeService {
    List<Loai_xe> display();

    void create(Loai_xe loai_xe);

    Loai_xe edit(int id);

    void update(Loai_xe loai_xe);

    void delete(int id);

    List<Loai_xe> searchName(String name);
}
