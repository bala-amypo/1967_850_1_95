package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
    List<TransactionLog> findByUser(User user);
    List<TransactionLog> findByUserAndTransactionDateBetween(
            User user, LocalDate start, LocalDate end);
}
