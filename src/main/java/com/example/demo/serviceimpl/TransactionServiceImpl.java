package com.example.demo.service.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository repository;

    public TransactionServiceImpl(TransactionLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TransactionLog> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public TransactionLog saveTransaction(TransactionLog transaction) {
        return repository.save(transaction);
    }
}
