package com.example.hospital_management.repository;

import com.example.hospital_management.model.Hopital;
import com.example.hospital_management.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoptialRepositoryImpl implements IHopitalRepository{
    private final String SELECT = "select * from Product p join Category c on p.id=c.id";
    private final String INSERT = "insert into Product(name, price, number, color, mota, id) \n" +
            "values (?, ?, ?, ?, ?, ?)";
    private final String SELECT_PRODUCT = "select p.*, c.type from Product p join Category c on p.id=c.id where p.id_product=?";
    private final String UPDATE = "update Product set name = ?, price = ?, number = ?, color = ?, mota = ?, id = ? where id_product = ?";
    private final String DELETE = "delete from Product where id_product = ?";
    private final String SEARCH_NAME = "select p.*, c.type from Product p join Category c on p.id=c.id where p.name like ?";
    @Override
    public List<Hopital> display() {
        List<Hopital> list = new ArrayList<>();

        try (
                Connection connection = BaseRepository.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()){
                int id_hopital = resultSet.getInt("id_hopital");
                Date date_in = resultSet.getDate("date_in");
                Date date_out = resultSet.getDate("date_out");
                String reason = resultSet.getString("reason");
                int id_patient = resultSet.getInt("id_patient");
                String name_patient = resultSet.getString("name_patient");
                int age_patient = resultSet.getInt("age_patient");
                Patient patient = new Patient(id_patient, name_patient, age_patient);
                Hopital hopital = new Hopital(id_hopital, date_in, date_out, reason, patient);
                list.add(hopital);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void create(Hopital hopital) {
        try(
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
                ){
                    preparedStatement.setDate(1, (java.sql.Date) hopital.getDate_in());
                    preparedStatement.setDate(2, (java.sql.Date) hopital.getDate_out());
                    preparedStatement.setString(3, hopital.getReason());
                    preparedStatement.setInt(4, hopital.getPatient().getId_patient());
                    preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Hopital edit(int id) {
        try(
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);
        ){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_hopital = resultSet.getInt("id_hopital");
                Date date_in = resultSet.getDate("date_in");
                Date date_out = resultSet.getDate("date_out");
                String reason = resultSet.getString("reason");
                int id_patient = resultSet.getInt("id_patient");
                String name_patient = resultSet.getString("name_patient");
                int age_patient = resultSet.getInt("age_patient");
                Patient patient = new Patient(id_patient, name_patient, age_patient);
                Hopital hopital = new Hopital(id_hopital, date_in, date_out, reason, patient);
                return hopital;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Hopital hopital) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        ){
            preparedStatement.setDate(1, (java.sql.Date) hopital.getDate_in());
            preparedStatement.setDate(2, (java.sql.Date) hopital.getDate_out());
            preparedStatement.setString(3, hopital.getReason());
            preparedStatement.setInt(4, hopital.getPatient().getId_patient());
            preparedStatement.setString(5, hopital.getPatient().getName_patient());
            preparedStatement.setInt(6, hopital.getPatient().getAge_patient());
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
    public List<Hopital> searchNamePatient(String name) {
        return null;
    }
}
