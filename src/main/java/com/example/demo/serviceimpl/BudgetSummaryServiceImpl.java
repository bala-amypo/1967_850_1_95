package com.example.demo.serviceimpl;

import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository repository;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public BudgetSummary createSummary(BudgetSummary summary) {
        return repository.save(summary);
    }

    @Override
    public List<BudgetSummary> getAllSummaries() {
        return repository.findAll();
    }

    @Override
    public BudgetSummary getSummaryById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
