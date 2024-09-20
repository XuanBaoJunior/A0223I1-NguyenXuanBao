package com.example.ss3_hom_dien_tu.repository;


import com.example.ss3_hom_dien_tu.model.MailBox;

public interface IMailBoxRepository {
    MailBox findAll();
    void save(MailBox mailBox);
}
