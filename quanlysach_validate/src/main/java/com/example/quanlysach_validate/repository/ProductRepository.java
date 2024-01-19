package com.example.quanlysach_validate.repository;

import com.example.quanlysach_validate.model.Category;
import com.example.quanlysach_validate.model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private final String SELECT = "SELECT p.*, c.type FROM Product p JOIN Category c ON p.id_category = c.id_category";
    private final String INSERT = "insert into Product(name, price, number, color, mota, id) \n" +
            "values (?, ?, ?, ?, ?, ?)";
    private final String SELECT_PRODUCT = "select p.*, c.type from Product p join Category c on p.id=c.id where p.id_product=?";
    private final String UPDATE = "update Product set name = ?, price = ?, number = ?, color = ?, mota = ?, id = ? where id_product = ?";
    private final String DELETE = "delete from Product where id_product = ?";
    private final String SEARCH_NAME = "select p.*, c.type from Product p join Category c on p.id=c.id where p.name like ?";
    @Override
    public List<Product> display() {
        List<Product> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()){
                int id_product = resultSet.getInt("id_product");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                int number = resultSet.getInt("number");
                String color = resultSet.getString("color");
                String mota = resultSet.getString("mota");
                int id_category = resultSet.getInt("id_category");
                String type = resultSet.getString("type");
                Category category = new Category(id_category, type);
                Product product = new Product(id_product, name, price, number, color, mota, category);
                list.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public Product edit(int id) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> searchName(String name) {
        return null;
    }
}
