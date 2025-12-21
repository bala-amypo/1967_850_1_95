package com.example.demo.service;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionLogRepository repo;

    public TransactionService(TransactionLogRepository repo) {
        this.repo = repo;
    }

    public TransactionLog addTransaction(TransactionLog log) {
        return repo.save(log);
    }
}
