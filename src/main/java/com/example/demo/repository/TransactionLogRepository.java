package com.example.demo.repository;

import java.time.LocalDate;
import java.util.*;
import com.example.demo.model.*;

public interface TransactionLogRepository {
    TransactionLog save(TransactionLog log);
    List<TransactionLog> findByUser(User user);
    List<TransactionLog> findByUserAndTransactionDateBetween(
            User user, LocalDate start, LocalDate end);
}
