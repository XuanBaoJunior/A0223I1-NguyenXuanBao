package com.example.demobaibook.Service;

import com.example.demobaibook.Model.Book;

import java.util.List;

public interface IBookService {
    List<Book> display();
    Book findall(int id);
    void update(int id, int number);
}
