package com.example.demodb.repository.impl;

import com.example.demodb.model.Product;
import com.example.demodb.repository.IProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    public static final String DELETE = "delete from product where id = ?";

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Product product;

        try {
            Statement statement = BaseRepository.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product");
            while (resultSet.next()){
                product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setDescribe(resultSet.getString("describe"));
                product.setProducer(resultSet.getString("producer"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnectionJavaToDB()
                    .prepareStatement("insert into demodb(name, price, describe, producer) value (?,?,?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescribe());
            preparedStatement.setString(4, product.getProducer());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnectionJavaToDB()
                    .prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
