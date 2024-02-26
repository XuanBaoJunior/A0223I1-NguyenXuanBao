package com.example.baithimd3.Service;

import com.example.baithimd3.Model.NguoiThue;
import com.example.baithimd3.Repository.INguoiThueRepository;
import com.example.baithimd3.Repository.NguoiThueRepository;

import java.util.List;

public class NguoiThueService implements INguoiThueService{
    private INguoiThueRepository iNguoiThueRepository = new NguoiThueRepository();
    @Override
    public List<NguoiThue> display() {
        return iNguoiThueRepository.display();
    }

    @Override
    public void create(NguoiThue nguoiThue) {
        iNguoiThueRepository.create(nguoiThue);
    }

    @Override
    public NguoiThue edit(int id) {
        return iNguoiThueRepository.edit(id);
    }

    @Override
    public void update(NguoiThue nguoiThue) {
        iNguoiThueRepository.update(nguoiThue);
    }

    @Override
    public void delete(String id) {
        iNguoiThueRepository.delete(id);
    }

    @Override
    public List<NguoiThue> searchName(String name) {
        return iNguoiThueRepository.searchName(name);
    }
}
