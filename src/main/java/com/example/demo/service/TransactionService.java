package com.example.demo.service;

import com.example.demo.model.TransactionLog;

import java.util.List;

public interface TransactionService {

    TransactionLog create(TransactionLog transaction);

    List<TransactionLog> getAll();

    TransactionLog getById(Long id);

    TransactionLog update(Long id, TransactionLog transaction);

    void delete(Long id);
}
