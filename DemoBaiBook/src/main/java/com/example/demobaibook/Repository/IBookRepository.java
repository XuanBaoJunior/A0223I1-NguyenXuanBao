package com.example.demobaibook.Repository;

import com.example.demobaibook.Model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> display();
    Book findall(int id);
    void update(int id, int number);
}
