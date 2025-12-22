package com.example.demo.serviceimpl;

import com.example.demo.model.Category;
import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.TransactionService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public TransactionServiceImpl(TransactionLogRepository repository) {
        this.repository = repository;
    }

    // ✅ POST — UNCHANGED
    @Override
    public TransactionLog create(TransactionLog transaction) {

        if (transaction.getCategory() != null && transaction.getCategory().getId() != null) {
            Category managedCategory =
                    entityManager.find(Category.class, transaction.getCategory().getId());
            transaction.setCategory(managedCategory);
        }

        if (transaction.getUser() != null && transaction.getUser().getId() != null) {
            User managedUser =
                    entityManager.find(User.class, transaction.getUser().getId());
            transaction.setUser(managedUser);
        }

        TransactionLog saved = repository.save(transaction);

        // prevent lazy init issues
        if (saved.getCategory() != null) saved.getCategory().getId();
        if (saved.getUser() != null) saved.getUser().getId();

        return saved;
    }

    // ✅ GET — UNCHANGED
    @Override
    public List<TransactionLog> getAll() {
        return repository.findAll();
    }

    @Override
    public TransactionLog getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    // 🔴 PUT — FIXED (NULL-SAFE MANAGED ENTITIES)
    @Override
    public TransactionLog update(Long id, TransactionLog transaction) {

        TransactionLog existing = getById(id);

        existing.setAmount(transaction.getAmount());
        existing.setDescription(transaction.getDescription());
        existing.setTransactionDate(transaction.getTransactionDate());

        if (transaction.getCategory() != null && transaction.getCategory().getId() != null) {
            Category managedCategory =
                    entityManager.find(Category.class, transaction.getCategory().getId());
            if (managedCategory != null) { // 🔥 FIX
                existing.setCategory(managedCategory);
            }
        }

        if (transaction.getUser() != null && transaction.getUser().getId() != null) {
            User managedUser =
                    entityManager.find(User.class, transaction.getUser().getId());
            if (managedUser != null) { // 🔥 FIX
                existing.setUser(managedUser);
            }
        }

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
