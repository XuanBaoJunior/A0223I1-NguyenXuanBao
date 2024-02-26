package com.example.baithimd3.Repository;

import com.example.baithimd3.Model.NguoiThue;

import java.util.List;

public interface INguoiThueRepository {
    List<NguoiThue> display();

    void create(NguoiThue nguoiThue);

    NguoiThue edit(int id);

    void update(NguoiThue nguoiThue);

    void delete(String id);

    List<NguoiThue> searchName(String name);
}
