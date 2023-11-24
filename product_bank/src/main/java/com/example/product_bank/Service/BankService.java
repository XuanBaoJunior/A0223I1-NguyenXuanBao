package com.example.product_bank.Service;

import com.example.product_bank.Model.Bank;
import com.example.product_bank.Repository.BankRepository;
import com.example.product_bank.Repository.IBankRepository;

import java.util.List;

public class BankService implements IBankService{
    private IBankRepository iBankRepository = new BankRepository();
    @Override
    public List<Bank> findAll() {
        return iBankRepository.findAll();
    }

    @Override
    public Bank findIdBank(int id) {
        return iBankRepository.findIdBank(id);
    }

    @Override
    public List<Bank> find(int id) {
        return iBankRepository.find(id);
    }

    @Override
    public Bank findName(String name) {
        return iBankRepository.findName(name);
    }
}
