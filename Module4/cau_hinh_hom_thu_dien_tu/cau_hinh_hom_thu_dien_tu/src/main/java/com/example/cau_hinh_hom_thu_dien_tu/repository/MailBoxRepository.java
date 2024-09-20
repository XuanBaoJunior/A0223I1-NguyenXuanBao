package com.example.cau_hinh_hom_thu_dien_tu.repository;

import com.example.cau_hinh_hom_thu_dien_tu.model.MailBox;
import org.springframework.stereotype.Repository;

@Repository
public class MailBoxRepository implements  IMailBoxRepository{
    MailBox mailBox = new MailBox("English", 20, true, "good");
    @Override
    public MailBox findAll() {
        return mailBox;
    }

    @Override
    public void save(MailBox mailBox) {
        this.mailBox = mailBox;
    }
}
