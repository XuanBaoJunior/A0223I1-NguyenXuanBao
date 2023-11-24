package com.example.product_bank.Repository;

import com.example.product_bank.Model.Bank;
import com.example.product_bank.Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
//    private final String SELECT = "SELECT * FROM Product p JOIN Bank b ON p.id = b.id";
    private final String SELECT = "SELECT p.*, b.name AS bank_name FROM Product p JOIN Bank b ON p.id = b.id";
    private final String INSERT = "INSERT INTO Product(name, number, mota, id) VALUES (?, ?, ?, ?)";
    private final String SELECT_PRODUCT = "SELECT p.*, b.name AS bank_name FROM Product p JOIN Bank b ON p.id = b.id WHERE p.id_product=?";
    private final String UPDATE = "UPDATE Product SET name = ?, number = ?, mota = ?, id = ? WHERE id_product = ?";
    private final String DELETE = "DELETE FROM Product WHERE id_product = ?";
    private final String SEARCH_NAME = "SELECT p.*, b.name AS bank_name FROM Product p JOIN Bank b ON p.id = b.id WHERE p.name LIKE ?";

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
                int number = resultSet.getInt("number");
                String mota = resultSet.getString("mota");
                int id = resultSet.getInt("id");
                String namebank = resultSet.getString("bank_name");
                Bank bank = new Bank(id, namebank);
                Product product = new Product(id_product, name, number, mota, bank);
                list.add(product);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void create(Product product) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        ) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getNumber());
            preparedStatement.setString(3, product.getMota());
            preparedStatement.setInt(4, product.getBank().getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product edit(int id) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);
        ) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id_product = resultSet.getInt("id_product");
                    String name = resultSet.getString("name");
                    int number = resultSet.getInt("number");
                    String mota = resultSet.getString("mota");
                    int id2 = resultSet.getInt("id");
                    String namebank = resultSet.getString("bank_name");
                    Bank bank = new Bank(id2, namebank);
                    Product product = new Product(id_product, name, number, mota, bank);
                    return product;
}
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Product product) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        ){
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getNumber());
            preparedStatement.setString(3, product.getMota());
            preparedStatement.setInt(4, product.getBank().getId());
            preparedStatement.setInt(5, product.getId_product());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> searchName(String name) {
        return null;
    }
}
