package com.example.product_management.repository.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import static com.example.product_management.repository.impl.BaseRepository.entityManager;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
        List<Product> list = entityManager.createQuery("SELECT s FROM Products s", Product.class).getResultList();
        return list;
    }

    @Override
    public Product findById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Transactional
    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> search(String name) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Products p where p.name like :name", Product.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

}
