package com.example.demo.serviceimpl;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository repository;

    public TransactionServiceImpl(TransactionLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransactionLog create(TransactionLog transaction) {
        return repository.save(transaction);
    }

    @Override
    public List<TransactionLog> getAll() {
        return repository.findAll();
    }

    @Override
    public TransactionLog getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    @Override
    public TransactionLog update(Long id, TransactionLog transaction) {
        TransactionLog existing = getById(id);

        existing.setAmount(transaction.getAmount());
        existing.setDescription(transaction.getDescription());
        existing.setTransactionDate(transaction.getTransactionDate());
        existing.setCategory(transaction.getCategory());
        existing.setUser(transaction.getUser());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
