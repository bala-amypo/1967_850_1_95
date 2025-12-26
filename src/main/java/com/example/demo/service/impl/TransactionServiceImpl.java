package com.example.demo.service.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private TransactionLogRepository TransactionLogRepository;
    private UserRepository userRepository;

    // REQUIRED by tests
    public TransactionServiceImpl() {
    }

    // OPTIONAL for Spring
    public TransactionServiceImpl(TransactionLogRepository transactionLogRepository,
                                  UserRepository userRepository) {
        this.TransactionLogRepository = TransactionLogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TransactionLog addTransaction(Long userId, TransactionLog transactionLog) {
        return TransactionLogRepository.save(transactionLog);
    }

   @Override
public List<TransactionLog> getUserTransactions(Long userId) {
    return TransactionLogRepository.findByUserId(userId);
}

}
