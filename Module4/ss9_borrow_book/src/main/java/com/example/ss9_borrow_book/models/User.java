package com.example.ss9_borrow_book.models;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;

    @OneToMany(mappedBy = "user")
    private List<BorrowedBook> borrowedBooks;

}
