package com.example.cau_hinh_hom_thu_dien_tu.service;

import com.example.cau_hinh_hom_thu_dien_tu.model.MailBox;
import com.example.cau_hinh_hom_thu_dien_tu.repository.IMailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailBoxService implements  IMailBoxService{
    @Autowired
    public IMailBoxRepository iMailBoxRepository;
    @Override
    public MailBox findAll() {
        return iMailBoxRepository.findAll();
    }

    @Override
    public void save(MailBox mailBox) {
        iMailBoxRepository.save(mailBox);
    }
}
