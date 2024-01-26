package com.example.benh_an.Repository;

import com.example.benh_an.Model.Benh_an;

import java.util.List;

public interface IBenh_anRepository {
    List<Benh_an> display();

    Boolean create(Benh_an benh_an);

    String createShow (String idBenhNhan);
    String createNewID1(Benh_an benh_an);
}
