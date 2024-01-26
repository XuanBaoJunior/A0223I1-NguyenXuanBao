package com.example.xe_co.Repository;

import com.example.xe_co.Model.Loai_xe;

import java.util.List;

public interface ILoai_xeRepository {
    List<Loai_xe> display();

    void create(Loai_xe loai_xe);

    Loai_xe edit(int id_loai_xe);

    void update(Loai_xe loai_xe);

    void delete(int id);

    List<Loai_xe> searchName(String name);
}
