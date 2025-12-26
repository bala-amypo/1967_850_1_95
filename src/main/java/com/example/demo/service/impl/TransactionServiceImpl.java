package com.example.demo.service.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository repo;
    private final UserRepository userRepo;

    public TransactionServiceImpl(TransactionLogRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public TransactionLog addTransaction(Long userId, TransactionLog log) {
        log.validate();
        return repo.save(log);
    }

    public List<TransactionLog> getUserTransactions(Long userId) {
        return repo.findByUser(userRepo.findById(userId).get());
    }
}
