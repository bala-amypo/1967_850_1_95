package com.example.demo.service;

import com.example.demo.entity.Transaction;
import java.util.List;

public interface TransactionService {
    List<Transaction> findAll();
    Transaction create(Transaction transaction);
}
