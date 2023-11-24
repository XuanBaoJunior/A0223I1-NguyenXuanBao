package com.example.product_bank.Repository;

import com.example.product_bank.Model.Bank;

import java.util.List;

public interface IBankRepository {
    List<Bank> findAll();

    Bank findIdBank(int id);

    List<Bank> find(int id);
    Bank findName(String bankName);
}
