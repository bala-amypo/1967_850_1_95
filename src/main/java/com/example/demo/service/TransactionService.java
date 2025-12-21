package com.example.demo.service;

import com.example.demo.model.TransactionLog;

import java.util.List;

public interface TransactionService {

    TransactionLog createTransaction(TransactionLog transaction);

    List<TransactionLog> getAllTransactions();

    TransactionLog getTransactionById(Long id);
}
