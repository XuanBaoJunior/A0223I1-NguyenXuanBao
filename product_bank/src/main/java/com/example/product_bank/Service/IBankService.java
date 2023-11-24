package com.example.product_bank.Service;

import com.example.product_bank.Model.Bank;

import java.util.List;

public interface IBankService {
    List<Bank> findAll();

    Bank findIdBank(int id);

    List<Bank> find(int id);

    Bank findName(String name);
}
