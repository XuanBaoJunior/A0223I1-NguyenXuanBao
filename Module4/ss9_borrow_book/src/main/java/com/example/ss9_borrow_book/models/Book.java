package com.example.ss9_borrow_book.models;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;
    private Integer quantity;
    @OneToMany(mappedBy = "book")
    private List<BorrowedBook> borrowedBooks;
}