package com.example.demo.service.impl;

import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository repo;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<?> getAll() {
        return repo.findAll();
    }

    // ✅ ADD
    @Override
    public BudgetSummary create(BudgetSummary summary) {
        summary.setGeneratedAt(LocalDateTime.now());
        return repo.save(summary);
    }
}
