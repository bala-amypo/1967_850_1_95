package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "transaction_logs")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    private Double amount;

    private String description;

    private LocalDate transactionDate;

    public void validate() {
        if (amount == null || amount <= 0) {
            throw new BadRequestException("Amount must be greater than zero");
        }
        if (transactionDate.isAfter(LocalDate.now())) {
            throw new BadRequestException("Transaction date cannot be in the future");
        }
    }
}
