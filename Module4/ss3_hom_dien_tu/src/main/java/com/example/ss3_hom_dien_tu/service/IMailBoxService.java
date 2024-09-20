package com.example.ss3_hom_dien_tu.service;


import com.example.ss3_hom_dien_tu.model.MailBox;

public interface IMailBoxService {
    MailBox findAll();
    void save(MailBox mailBox);
}
