package com.example.product_bank.Repository;

import com.example.product_bank.Model.Bank;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankRepository implements IBankRepository{
    private final String SELECT_BANK = "select * from bank";
    private final String SELECT_ID = "select * from bank where id = ?";
    private final String SELECT = "select * from bank where id != ?";
    private final String SELECT_BANK_NAME = "select * from bank where name = ?";
    @Override
    public List<Bank> findAll() {
        List<Bank> list = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection();
             Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery(SELECT_BANK);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String namebank = resultSet.getString("name");
                Bank bank = new Bank(id, namebank);
                list.add(bank);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Bank findIdBank(int id) {
        try(Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idBank = resultSet.getInt("id");
                String namebank = resultSet.getString("name");
                Bank bank = new Bank(idBank, namebank);
                return bank;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Bank> find(int id) {
        List<Bank> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
        ) {
preparedStatement.setInt(1, id);
ResultSet resultSet = preparedStatement.executeQuery();
while (resultSet.next()){
    int idBank = resultSet.getInt("id");
    String namebank = resultSet.getString("name");
    Bank bank = new Bank(idBank, namebank);
    list.add(bank);
}
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Bank findName(String bankName) {
        try(Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BANK_NAME);) {
            preparedStatement.setString(1,bankName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idBank = resultSet.getInt("id");
                String namebank = resultSet.getString("name");
                Bank bank = new Bank(idBank, namebank);
                return bank;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
