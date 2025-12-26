package com.example.demo.service.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository repo;
    private final UserRepository userRepo;

    public TransactionServiceImpl(TransactionLogRepository r, UserRepository u) {
        this.repo = r;
        this.userRepo = u;
    }

    public TransactionLog addTransaction(Long userId, TransactionLog t) {
        User u = userRepo.findById(userId).orElseThrow();
        t.validate();
        return repo.save(t);
    }

    public List<TransactionLog> getUserTransactions(Long userId) {
        User u = userRepo.findById(userId).orElseThrow();
        return repo.findByUser(u);
    }
}
