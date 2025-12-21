package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;
public interface TransactionService {
    TransactionLog addTransaction(Long userId, TransactionLog log);
    List<TransactionLog> getUserTransactions(Long userId);
}
