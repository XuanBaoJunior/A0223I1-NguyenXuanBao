package com.example.demo_bai_test.services;

import com.example.demo_bai_test.models.Staffs;
import com.example.demo_bai_test.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    StaffRepository staffRepository;

    public Staffs save(Staffs entity) {
        return staffRepository.save(entity);
    }

    public List<Staffs> saveAll(List<Staffs> entities) {
        return (List<Staffs>)staffRepository.saveAll(entities);
    }

    public Optional<Staffs> findById(String s) {
        return staffRepository.findById(s);
    }

    public boolean existsById(String s) {
        return staffRepository.existsById(s);
    }

    public Iterable<Staffs> findAll() {
        return staffRepository.findAll();
    }

    public List<Staffs> findAllById(List<String> ids) {
        return (List<Staffs>)staffRepository.findAllById(ids);
    }

    public long count() {
        return staffRepository.count();
    }

    public void deleteById(String s) {
        staffRepository.deleteById(s);
    }

    public void delete(Staffs entity) {
        staffRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends String> strings) {
        staffRepository.deleteAllById(strings);
    }

    public void deleteAll(List<Staffs> entities) {
        staffRepository.deleteAll(entities);
    }

    public void deleteAll() {
        staffRepository.deleteAll();
    }
}
