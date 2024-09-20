package com.example.cau_hinh_hom_thu_dien_tu.service;

import com.example.cau_hinh_hom_thu_dien_tu.model.MailBox;

public interface IMailBoxService {
    MailBox findAll();
    void save(MailBox mailBox);
}
