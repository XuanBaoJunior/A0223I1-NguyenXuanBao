package com.example.quan_ly_sach.repository.impl;

import com.example.quan_ly_sach.model.Product;
import com.example.quan_ly_sach.repository.IProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String GETALLPRODUCT = "select * from products";
    private static final String DELETEPRODUCT = "select from products where id = ?";
    private static final String CREATEPRODUCT = "insert into products (name, price, author, describeBook)\n"+
            "values (?,?,?,?);";
    private static final String UPDATEPRODUCT = "update products set name = ?, price = ?, author = ?, describeBook = ? where id = ?:";

    @Override
    public void createProduct(Product product) {
        try(Connection connection = BaseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATEPRODUCT);) {
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setString(3,product.getAuthor());
            preparedStatement.setString(4,product.getDescribeBook());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        try (Connection connection = BaseRepository.getConnectionJavaToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATEPRODUCT);){
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setString(3,product.getAuthor());
            preparedStatement.setString(4,product.getDescribeBook());
            preparedStatement.setInt(5,product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int id) {
        Connection connection = BaseRepository.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETEPRODUCT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        try {
            Statement statement = BaseRepository.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery(GETALLPRODUCT);
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));
                product.setAuthor(resultSet.getString(4));
                product.setDescribeBook(resultSet.getString(5));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
