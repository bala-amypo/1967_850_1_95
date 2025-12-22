package com.example.demo.service.impl;

import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository repo;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository repo) {
        this.repo = repo;
    }

    public List<?> getAll() {
        return repo.findAll();
    }
}
