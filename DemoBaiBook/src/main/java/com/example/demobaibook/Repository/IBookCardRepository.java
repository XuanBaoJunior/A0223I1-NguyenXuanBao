package com.example.demobaibook.Repository;

import com.example.demobaibook.Model.Book_card;

import java.util.List;

public interface IBookCardRepository {
    void listBookCard(Book_card bookCard);
    List<Book_card> displayBookCard();
    void updateStatus(int id, boolean status);
    List<Book_card> searchBookAndStudent(String book, String student);
}
