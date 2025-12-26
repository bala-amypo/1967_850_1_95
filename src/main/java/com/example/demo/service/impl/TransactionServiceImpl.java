package com.example.demo.service.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public TransactionLog addTransaction(Long userId, TransactionLog transactionLog) {
        // stub implementation
        return transactionLog;
    }

    @Override
    public List<TransactionLog> getUserTransactions(Long userId) {
        // stub implementation
        return Collections.emptyList();
    }
}
