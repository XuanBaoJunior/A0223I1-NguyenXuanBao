package com.example.baithimd3.Service;

import com.example.baithimd3.Model.NguoiThue;

import java.util.List;

public interface INguoiThueService {
    List<NguoiThue> display();

    void create(NguoiThue nguoiThue);

    NguoiThue edit(int id);

    void update(NguoiThue nguoiThue);

    void delete(String id);

    List<NguoiThue> searchName(String name);
}
