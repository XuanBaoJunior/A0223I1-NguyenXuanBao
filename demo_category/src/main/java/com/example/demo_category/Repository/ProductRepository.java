package com.example.demo_category.Repository;

import com.example.demo_category.Model.Category;
import com.example.demo_category.Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private final String SELECT = "SELECT p.*, c.type_category " +
            "FROM product p " +
            "JOIN category c ON p.id_category = c.id_category";

    private final String INSERT = "INSERT INTO product(name_product, price_product, number_product, color_product, describe_product, id_category) \n" +
            "VALUES (?, ?, ?, ?, ?, ?)";

    private final String SELECT_PRODUCT = "SELECT p.*, c.type_category " +
            "FROM product p " +
            "JOIN category c ON p.id_category = c.id_category " +
            "WHERE p.id_product=?";
    private final String UPDATE = "UPDATE product " +
            "SET name_product = ?, price_product = ?, number_product = ?, " +
            "color_product = ?, describe_product = ?, id_category = ? " +
            "WHERE id_product = ?";
    private final String DELETE = "DELETE FROM product WHERE id_product = ?";
    private final String SEARCH_NAME = "SELECT p.*, c.type_category " +
            "FROM product p " +
            "JOIN category c ON p.id_category = c.id_category " +
            "WHERE p.name_product LIKE ?";
    @Override
    public List<Product> display() {
        List<Product> list = new ArrayList<>();
        try(Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()){
                int id_product = resultSet.getInt("id_product");
                String name_product = resultSet.getString("name_product");
                String color_product = resultSet.getString("color_product");
                String describe_product = resultSet.getString("describe_product");
                int id_category = resultSet.getInt("id_category");
                String type_category = resultSet.getString("type_category");
                Category category = new Category(id_category, type_category);
                Product product = new Product(id_product, name_product, color_product , describe_product, category);
                list.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
return list;
    }

    @Override
    public void create(Product product) {
        try(Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        ) {
            preparedStatement.setString(1, product.getName_product());
            preparedStatement.setString(2, product.getColor_product());
            preparedStatement.setString(3, product.getColor_product());
            preparedStatement.setString(4, product.getDescribe_product());
            preparedStatement.setInt(5, product.getCategory().getId_category());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Product edit(int id) {
        try(Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_product = resultSet.getInt("id_product");
                String name_product = resultSet.getString("name_product");
                String color_product = resultSet.getString("color_product");
                String describe_product = resultSet.getString("describe_product");
                int id_category = resultSet.getInt("id_category");
                String type_category = resultSet.getString("type_category");
                Category category = new Category(id_category, type_category);
                Product product = new Product(id_product, name_product, color_product, describe_product, category);
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        }


    @Override
    public void update(Product product) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        ) {
            preparedStatement.setString(1, product.getName_product());
            preparedStatement.setString(2, product.getColor_product());
            preparedStatement.setString(3, product.getColor_product());
            preparedStatement.setString(4, product.getDescribe_product());
            preparedStatement.setInt(5, product.getCategory().getId_category());
            preparedStatement.setInt(6, product.getId_product());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> searchName(String name) {
        List<Product> productList = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME);
        ) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_product = resultSet.getInt("id_product");
                String name_product = resultSet.getString("name_product");
                String color_product = resultSet.getString("color_product");
                String describe_product = resultSet.getString("describe_product");
                int id_category = resultSet.getInt("id_category");
                String type_category = resultSet.getString("type_category");
                Category category = new Category(id_category, type_category);
                Product product = new Product(id_product, name_product, color_product ,describe_product, category);
                productList.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }
}
