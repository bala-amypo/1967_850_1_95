package com.example.demo.repository;

import com.example.demo.model.*;
import java.time.LocalDate;
import java.util.List;

public interface TransactionLogRepository {
    TransactionLog save(TransactionLog log);
    List<TransactionLog> findByUser(User user);
    List<TransactionLog> findByUserAndTransactionDateBetween(
            User user, LocalDate start, LocalDate end);
}
