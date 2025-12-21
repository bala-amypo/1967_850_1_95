package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String description;
    private LocalDate transactionDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;
}
