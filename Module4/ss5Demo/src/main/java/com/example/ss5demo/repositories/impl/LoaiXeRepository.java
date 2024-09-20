package com.example.ss5demo.repositories.impl;

import com.example.ss5demo.models.LoaiXe;
import com.example.ss5demo.repositories.ILoaiXeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class LoaiXeRepository implements ILoaiXeRepository {

    @Override
    public List<LoaiXe> findAll() {
        List<LoaiXe> list = BaseRepository.entityManager.createQuery("select l from loai_xe l",LoaiXe.class).getResultList();
        return list;
    }

    @Override
    public void save(LoaiXe loaiXe) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(loaiXe);
        entityTransaction.commit();
    }

    @Override
    public List<LoaiXe> findOneByID(Integer code) {
        List<LoaiXe> list = BaseRepository.entityManager.createQuery("select l from loai_xe l where id_loai_xe = :id_loai_xe",LoaiXe.class).setParameter("id_loai_xe",code).getResultList();
        return list;
    }
}
