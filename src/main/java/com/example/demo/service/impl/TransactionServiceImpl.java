package com.example.demo.service.impl;

import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public List<Transaction> getUserTransactions(Long userId) {
        // minimal stub
        return Collections.emptyList();
    }
}
