package com.example.demobaibook.Service;

import com.example.demobaibook.Model.Book;
import com.example.demobaibook.Repository.BookRepository;
import com.example.demobaibook.Repository.IBookRepository;

import java.util.List;

public class BookService implements IBookService{
    private IBookRepository iBookRepository = new BookRepository();

    @Override
    public List<Book> display() {
        return iBookRepository.display();
    }

    @Override
    public Book findall(int id) {
        return iBookRepository.findall(id);
    }

    @Override
    public void update(int id, int number) {
        iBookRepository.update(id, number);
    }
}
