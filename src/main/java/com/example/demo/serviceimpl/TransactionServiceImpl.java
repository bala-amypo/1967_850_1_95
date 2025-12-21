package com.example.demo.serviceimpl;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransactionLog createTransaction(TransactionLog transaction) {
        return repository.save(transaction);
    }

    @Override
    public List<TransactionLog> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public TransactionLog getTransactionById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
