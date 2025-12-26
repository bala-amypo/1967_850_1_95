package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TransactionService;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository logRepo;
    private final UserRepository userRepo;

    public TransactionServiceImpl(TransactionLogRepository logRepo, UserRepository userRepo) {
        this.logRepo = logRepo;
        this.userRepo = userRepo;
    }

    public TransactionLog addTransaction(Long userId, TransactionLog log) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));
        log.validate();
        return logRepo.save(log);
    }

    public List<TransactionLog> getUserTransactions(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));
        return logRepo.findByUser(user);
    }
}
