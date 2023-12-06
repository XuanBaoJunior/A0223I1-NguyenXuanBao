package com.example.quan_ly_book.repository.impl;

import com.example.quan_ly_book.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository{
    private static final String FINDID = "SELECT * FROM BOOK WHERE id_book = ?";
    private static final String FINDALL = "SELECT * FROM BOOK";
    private static final String DELETE = "DELETE FROM BOOK WHERE id_book = ?";
    private static final String CREATE = "INSERT INTO BOOK (name_book, author, quatity, description)\n" +
            "VALUES (?,?,?,?);";
    private static final String UPDATE = "UPDATE BOOK SET name_book = ? ,author = ?, quatity = ?, description = ? where id_book = ?;";
    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        try {
            Statement statement = BaseRepository.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery(FINDALL);
            while (resultSet.next()){
                Book book = new Book();
                book.setId_book(resultSet.getInt(1));
                book.setName_book(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setQuatity(resultSet.getString(4));
                book.setDescription(resultSet.getString(5));
                list.add(new Book(book.getId_book(), book.getName_book(), book.getAuthor(), book.getQuatity(), book.getDescription()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void create(Book book) {

            }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Book findById(int id) {
        Book book = null;
        try {
            Connection connection = BaseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                String nameBook = resultSet.getString("name_book");
                String author = resultSet.getString("author");
                String quantity = resultSet.getString("quatity");
                String desc =resultSet.getString("description");
                book = new Book(id,nameBook,author,quantity,desc);

            }
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
