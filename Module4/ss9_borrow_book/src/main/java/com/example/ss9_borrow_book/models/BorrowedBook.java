package com.example.ss9_borrow_book.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "borrowed_book")
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idBorrow;
    private String idUser;
    private String idBook;
    private Date dateBorrow;
    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;
}
