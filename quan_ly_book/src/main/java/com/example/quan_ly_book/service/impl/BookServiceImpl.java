package com.example.quan_ly_book.service.impl;

import com.example.quan_ly_book.model.Book;
import com.example.quan_ly_book.repository.impl.BookRepository;
import com.example.quan_ly_book.repository.impl.BookRepositoryImpl;

import java.util.List;

public class BookServiceImpl implements BookService{
    private BookRepository bookRepository = new BookRepositoryImpl();
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void create(Book book) {
        bookRepository.create(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.update(book);
    }

    @Override
    public void delete(String id) {
        bookRepository.delete(id);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }
}
