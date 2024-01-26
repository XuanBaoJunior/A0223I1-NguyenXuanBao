package com.example.benh_an.Service;

import com.example.benh_an.Model.Benh_an;

import java.util.List;

public interface IBenh_anService {
    List<Benh_an> display();


    Boolean create(Benh_an benh_an);
}
