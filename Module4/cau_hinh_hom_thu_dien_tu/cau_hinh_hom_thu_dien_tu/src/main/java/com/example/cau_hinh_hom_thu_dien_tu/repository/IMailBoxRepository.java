package com.example.cau_hinh_hom_thu_dien_tu.repository;

import com.example.cau_hinh_hom_thu_dien_tu.model.MailBox;

public interface IMailBoxRepository {
    MailBox findAll();
    void save(MailBox mailBox);
}
